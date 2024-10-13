package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class FeedGetFeedRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    /** at-url  */
    var feed: String? = null
    var limit: Int? = null
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("feed", feed)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
