package work.socialhub.kbsky.model.share

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.RecordPolymorphicSerializer

/**
 * @see work.socialhub.kbsky.model.bsky.actor.ActorProfile
 * @see work.socialhub.kbsky.model.bsky.graph.GraphFollow
 * @see work.socialhub.kbsky.model.bsky.graph.GraphBlock
 * @see work.socialhub.kbsky.model.bsky.feed.FeedLike
 * @see work.socialhub.kbsky.model.bsky.feed.FeedPost
 * @see work.socialhub.kbsky.model.bsky.feed.FeedRepost
 */
@Serializable(with = RecordPolymorphicSerializer::class)
abstract class RecordUnion {
    @SerialName("\$type")
    abstract var type: String
}
