package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.FeedDefsBookmarkPolymorphicSerializer

/**
 * @see FeedDefsNotFoundPost
 * @see FeedDefsPostView
 */
@Serializable(with = FeedDefsBookmarkPolymorphicSerializer::class)
interface FeedDefsBookmarkItemUnion {
    @SerialName("\$type")
    val type: String
}

val FeedDefsBookmarkItemUnion.asNotFoundPost get() = this as? FeedDefsNotFoundPost
val FeedDefsBookmarkItemUnion.asPostView get() = this as? FeedDefsPostView