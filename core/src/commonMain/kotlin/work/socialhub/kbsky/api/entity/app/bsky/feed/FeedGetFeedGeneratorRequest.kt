package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class FeedGetFeedGeneratorRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    /** at-uri  */
    var feed: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("feed", feed)
        }
    }
}
