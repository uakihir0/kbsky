package work.socialhub.kbsky.stream.util

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
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
    val uri: String
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
            println(">> bytesListener")
            this.onMessage(it)
        }
        this.client.onOpenListener = {
            println(">> onOpenListener")
            this.isOpen = true
            this.openedCallback?.onOpened()
        }
        this.client.onCloseListener = {
            println(">> onCloseListener")
            this.isOpen = false
            this.closedCallback?.onClosed(false)
        }
    }

    fun open() {
        runBlocking {
            launch { client.startGet() }
        }
    }

    fun close() {
        client.close()
    }

    @OptIn(ExperimentalSerializationApi::class, ExperimentalStdlibApi::class)
    fun onMessage(data: ByteArray) {
        try {
            var tmp = data.copyOf()
            val item: StreamRoot = Cbor {
                ignoreUnknownKeys = true
            }.decodeFromByteArray(data)

            val length = Cbor {
                ignoreUnknownKeys = true
            }.encodeToByteArray(item).size
            println(length)

            // {"op":"1","t":"#commit"}
            // 上記のような形式のデータは使い方が分からないので無視
            if (item.op == 1 && item.t == "#commit") {
                return
            }

            // println(data.toHexString())
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
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
