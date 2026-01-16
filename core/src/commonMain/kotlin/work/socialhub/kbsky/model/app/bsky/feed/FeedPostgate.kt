package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedPostgate(
    @SerialName("\$type")
    override var type: String = TYPE,
    var createdAt: String? = null,
    var post: String? = null,
    var detachedEmbeddingUris: List<String>? = null,
    var embeddingRules: List<FeedPostgateEmbeddingRulesUnion>? = null,
) : RecordUnion() {
    companion object {
        const val TYPE = BlueskyTypes.FeedPostgate
    }
}
