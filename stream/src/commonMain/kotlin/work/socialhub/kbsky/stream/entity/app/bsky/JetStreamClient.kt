package work.socialhub.kbsky.stream.entity.app.bsky

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import work.socialhub.kbsky.internal.share._InternalUtility
import work.socialhub.kbsky.stream.entity.app.bsky.callback.JetStreamEventCallback
import work.socialhub.kbsky.stream.entity.app.bsky.model.Event
import work.socialhub.kbsky.stream.entity.callback.ClosedCallback
import work.socialhub.kbsky.stream.entity.callback.ErrorCallback
import work.socialhub.kbsky.stream.entity.callback.OpenedCallback
import work.socialhub.khttpclient.websocket.WebsocketRequest

class JetStreamClient(
    val uri: String,
) {
    var client = WebsocketRequest()
    var isOpen: Boolean = false

    var eventCallback: JetStreamEventCallback? = null
    private var openedCallback: OpenedCallback? = null
    private var closedCallback: ClosedCallback? = null
    private var errorCallback: ErrorCallback? = null

    fun eventCallback(callback: JetStreamEventCallback) = also { this.eventCallback = callback }
    fun openedCallback(callback: OpenedCallback) = also { this.openedCallback = callback }
    fun closedCallback(callback: ClosedCallback) = also { this.closedCallback = callback }
    fun errorCallback(callback: ErrorCallback) = also { this.errorCallback = callback }

    init {
        this.client.url(this.uri)
        this.client.bytesListener = {
            this.onMessage(it)
        }
        this.client.textListener = {
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

    suspend fun open() {
        client.open()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun openAsync() {
        GlobalScope.launch {
            client.open()
        }
    }

    fun close() {
        client.close()
    }

    private fun onMessage(text: String) {
        try {
            eventCallback?.let {
                val event = _InternalUtility.fromJson<Event>(text)
                it.onEvent(event)
            }
        } catch (e: Exception) {
            errorCallback?.onError(e)
        }
    }

    private fun onMessage(data: ByteArray) {
        // TODO: zstd の場合はこちらで処理することになる
    }
}
