package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedGetFeedGeneratorsRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    /** at-uri  */
    var feeds: List<String>? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("feeds", feeds)
        }
    }
}
