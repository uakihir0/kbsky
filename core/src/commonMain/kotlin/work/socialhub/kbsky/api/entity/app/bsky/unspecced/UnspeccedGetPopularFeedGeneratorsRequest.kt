package work.socialhub.kbsky.api.entity.app.bsky.unspecced


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class UnspeccedGetPopularFeedGeneratorsRequest(
    override val auth: AuthProvider,
    var limit: Int? = null,
    var cursor: String? = null,
    var query: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
            it.addParam("query", query)
        }
    }
}
