package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedGetFeedRequest internal constructor(
    accessJwt: String,
) : AuthRequest(accessJwt), MapRequest {

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
