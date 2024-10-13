package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class FeedGetFeedGeneratorsRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    /** at-uri  */
    var feeds: List<String>? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("feeds", feeds)
        }
    }
}
