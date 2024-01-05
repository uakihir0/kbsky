package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.internal.share._InternalUtility.toJson
import work.socialhub.kbsky.model.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.model.bsky.feed.FeedLike

class FeedLikeRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    var subject: RepoStrongRef? = null
    override var createdAt: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("subject", toJson(subject))
            it.addParam("createdAt", createdAt())
        }
    }

    fun toLike(): FeedLike {
        val like = FeedLike()
        like.subject = subject
        like.createdAt = createdAt()
        return like
    }
}
