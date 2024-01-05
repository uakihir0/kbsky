package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedGetTimelineRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var algorithm: String? = null
    var limit: Int? = null
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("algorithm", algorithm)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}