package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.internal.share._InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.feed.FeedPostgate
import work.socialhub.kbsky.model.app.bsky.feed.FeedPostgateEmbeddingRulesUnion

class FeedPostgateRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    override var createdAt: String? = null

    // at-uri
    lateinit var post: String

    // List of AT-URIs embedding this post that the author has detached from.
    var detachedEmbeddingUris: List<String>? = null

    var embeddingRules: List<FeedPostgateEmbeddingRulesUnion>? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("createdAt", createdAt())
            it.addParam("post", post)
            if (detachedEmbeddingUris != null) {
                it.addParam("detachedEmbeddingUris", toJson(detachedEmbeddingUris))
            }
            if (embeddingRules != null) {
                it.addParam("embeddingRules", toJson(embeddingRules))
            }
        }
    }

    fun toPostgate(): FeedPostgate {
        return FeedPostgate().also {
            it.createdAt = createdAt()
            it.post = post
            it.detachedEmbeddingUris = detachedEmbeddingUris
            it.embeddingRules = embeddingRules
        }
    }
}