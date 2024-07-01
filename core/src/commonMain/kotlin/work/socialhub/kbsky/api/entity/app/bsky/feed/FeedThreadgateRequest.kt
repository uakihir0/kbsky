package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.internal.share._InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgate
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgateAllowUnion

class FeedThreadgateRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    override var createdAt: String? = null
    lateinit var post: String

    var allow: List<FeedThreadgateAllowUnion>? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("post", post)
            if (allow != null) {
                it.addParam("allow", toJson(allow))
            }
            it.addParam("createdAt", createdAt())
        }
    }

    fun toThreadgate(): FeedThreadgate {
        return FeedThreadgate().also {
            it.createdAt = createdAt()
            it.post = post
            it.allow = allow
        }
    }
}