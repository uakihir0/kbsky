package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

data class FeedGetTimelineRequest(
    override val auth: AuthProvider,
    var algorithm: String? = null,
    var limit: Int? = null,
    var cursor: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("algorithm", algorithm)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}