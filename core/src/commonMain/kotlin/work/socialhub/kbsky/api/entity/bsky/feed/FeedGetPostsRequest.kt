package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedGetPostsRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var uris: List<String>? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("uris", uris)
        }
    }
}
