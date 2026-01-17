package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.PostgateEmbeddingRulesUnionPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see FeedPostgateDisableRule
 */
@Serializable(with = PostgateEmbeddingRulesUnionPolymorphicSerializer::class)
@JsExport
abstract class FeedPostgateEmbeddingRulesUnion {
    @SerialName("\$type")
    abstract var type: String

    val asPostgateDisableRule get() = this as? FeedPostgateDisableRule
}
