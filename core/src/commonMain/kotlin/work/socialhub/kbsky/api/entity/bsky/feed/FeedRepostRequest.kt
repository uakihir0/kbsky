package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.internal.share._InternalUtility.toJson
import work.socialhub.kbsky.model.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.model.bsky.feed.FeedRepost

class FeedRepostRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var subject: RepoStrongRef? = null
    var createdAt: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("subject", toJson(subject))
            it.addParam("createdAt", createdAt())
        }
    }

    fun toRepost(): FeedRepost {
        val repost = FeedRepost()
        repost.subject = subject
        repost.createdAt = createdAt()
        return repost
    }

    fun createdAt(): String {
        return createdAt ?: ""
        //_InternalUtility.dateFormat.format(java.util.Date())
    }
}
