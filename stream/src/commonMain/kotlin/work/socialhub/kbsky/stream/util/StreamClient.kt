package work.socialhub.kbsky.stream.util

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.decodeFromHexString
import work.socialhub.kbsky.ATProtocol
import work.socialhub.kbsky.api.entity.atproto.repo.RepoGetRecordRequest
import work.socialhub.kbsky.stream.util.callback.ClosedCallback
import work.socialhub.kbsky.stream.util.callback.ErrorCallback
import work.socialhub.kbsky.stream.util.callback.EventCallback
import work.socialhub.kbsky.stream.util.callback.OpenedCallback
import work.socialhub.kbsky.stream.util.model.StreamRoot
import work.socialhub.khttpclient.websocket.WebsocketRequest

class StreamClient(
    val atproto: ATProtocol,
    val uri: String,
    val filter: List<String> = listOf(),
) {

    var client = WebsocketRequest()
    var isOpen: Boolean = false

    var eventCallback: EventCallback? = null
    private var openedCallback: OpenedCallback? = null
    private var closedCallback: ClosedCallback? = null
    private var errorCallback: ErrorCallback? = null

    fun eventCallback(callback: EventCallback) = also { this.eventCallback = callback }
    fun openedCallback(callback: OpenedCallback) = also { this.openedCallback = callback }
    fun closedCallback(callback: ClosedCallback) = also { this.closedCallback = callback }
    fun errorCallback(callback: ErrorCallback) = also { this.errorCallback = callback }

    init {
        this.client.url(this.uri)
        this.client.bytesListener = {
            this.onMessage(it)
        }
        this.client.onOpenListener = {
            this.isOpen = true
            this.openedCallback?.onOpened()
        }
        this.client.onCloseListener = {
            this.isOpen = false
            this.closedCallback?.onClosed()
        }
    }

    fun open() {
        runBlocking {
            client.startGet()
        }
    }

    fun close() {
        client.close()
    }

    @OptIn(
        ExperimentalSerializationApi::class,
        ExperimentalStdlibApi::class
    )
    fun onMessage(data: ByteArray) {
        val cbor = Cbor { ignoreUnknownKeys = true }
        val hex = data.toHexString()

        // FIXME: kotlinx-serialization-cbor において結合された cbor データを
        //        デコードする方法が無いので適当にデータの先頭を推測してデコードする
        //        具体的には HexString において "a" の出てくる index を全て先頭と仮定
        //        a はマップの先頭で見られるタグだがそれ以外も可能性としてはある
        // MEMO: デコードに使用したバイト数などが分かればもう少し効率化が可能
        val indexes = hex
            .mapIndexed { i, c -> i to c }
            .filter { it.second == 'a' }
            .map { it.first }

        for (ind in indexes) {
            try {
                val sub = hex.substring(ind..<hex.length)
                val item = cbor.decodeFromHexString<StreamRoot>(sub)

                // ops の中身を見るためそれ以外は無視
                if (item.ops == null) {
                    continue
                }

                for (op in checkNotNull(item.ops)) {
                    if (op.action != "create") {
                        continue
                    }

                    val path = op.path
                    val repo = item.repo
                    val elements = path!!
                        .split("/")
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()

                    runBlocking {
                        launch {
                            try {
                                // 特定のコレクションのみを取得対象にしている場合はここでフィルタ実行
                                if (filter.isNotEmpty() && !filter.contains(elements[0])) {
                                    return@launch
                                }

                                val response = atproto
                                    .repo()
                                    .getRecord(
                                        RepoGetRecordRequest(
                                            repo = repo!!,
                                            collection = elements[0],
                                            rkey = elements[1]
                                        )
                                    )

                                eventCallback?.onEvent(
                                    response.data.cid,
                                    response.data.uri,
                                    response.data.value!!
                                )

                            } catch (e: Exception) {
                                println(
                                    "[Record Deleted?]"
                                            + " repo: " + repo
                                            + " path: " + path
                                )
                            }
                        }
                    }
                }

                // ops が確認できたら完了
                return

            } catch (e: Exception) {
                e.printStackTrace()
                continue
            }
        }
    }
}
