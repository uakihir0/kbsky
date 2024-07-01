package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.FeedDefsThreadPolymorphicSerializer

/**
 * @see FeedDefsThreadViewPost
 * @see FeedDefsNotFoundPost
 */
@Serializable(with = FeedDefsThreadPolymorphicSerializer::class)
abstract class FeedDefsThreadUnion {
    @SerialName("\$type")
    abstract var type: String

    val asViewPost get() = this as? FeedDefsThreadViewPost
    val asNotFoundPost get() = this as? FeedDefsNotFoundPost
}
