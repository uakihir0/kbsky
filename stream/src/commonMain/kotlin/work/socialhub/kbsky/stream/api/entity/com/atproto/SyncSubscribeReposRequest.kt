package work.socialhub.kbsky.stream.api.entity.com.atproto

import work.socialhub.kbsky.api.entity.share.MapRequest
import kotlin.js.JsExport

@JsExport
data class SyncSubscribeReposRequest(
    var cursor: String? = null,
    var filter: List<String> = listOf(),
) : MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("cursor", cursor)
        }
    }
}
