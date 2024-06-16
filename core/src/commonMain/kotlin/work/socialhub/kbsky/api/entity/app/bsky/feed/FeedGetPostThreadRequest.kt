package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedGetPostThreadRequest(
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
