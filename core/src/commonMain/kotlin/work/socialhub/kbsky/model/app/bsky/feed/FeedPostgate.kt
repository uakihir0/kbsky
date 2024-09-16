package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class FeedPostgate : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedPostgate
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var createdAt: String

    // at-uri
    lateinit var post: String

    var detachedEmbeddingUris: List<String>? = null

    var embeddingRules: List<FeedPostgateEmbeddingRulesUnion>? = null
}
