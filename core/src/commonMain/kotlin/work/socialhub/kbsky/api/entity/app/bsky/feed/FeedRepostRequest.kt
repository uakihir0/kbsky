package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.internal.share._InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef

@JsExport
data class FeedRepostRequest(
    override val auth: AuthProvider,
    var subject: RepoStrongRef? = null,
    override var createdAt: String? = null,
    val via: RepoStrongRef? = null,
) : AuthRequest(auth), MapRequest, RecordRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("subject", toJson(subject))
            it.addParam("createdAt", createdAt())
            it.addParam("via", toJson(via))
        }
    }

    fun toRepost(): FeedRepost {
        val repost = FeedRepost(
            subject = subject,
            createdAt = createdAt(),
            via = via,
        )
        return repost
    }
}
