package work.socialhub.kbsky.api.entity.app.bsky.graph


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class GraphGetListRequest(
    override val auth: AuthProvider,
    var list: String? = null,
    var limit: Int? = null,
    var cursor: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("list", list)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
