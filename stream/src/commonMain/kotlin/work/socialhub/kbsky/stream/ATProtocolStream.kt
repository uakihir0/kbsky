package work.socialhub.kbsky.stream

import work.socialhub.kbsky.stream.api.com.atproto.SyncResource
import kotlin.js.JsExport

@JsExport
interface ATProtocolStream {
    fun sync(): SyncResource
}
