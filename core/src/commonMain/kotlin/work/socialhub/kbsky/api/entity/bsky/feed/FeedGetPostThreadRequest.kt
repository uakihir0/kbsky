package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedGetPostThreadRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    lateinit var uri: String
    var depth: Int? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("uri", uri)
            it.addParam("depth", depth)
        }
    }
}
