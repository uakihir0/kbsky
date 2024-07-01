package work.socialhub.kbsky.model.share

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorProfile
import work.socialhub.kbsky.model.app.bsky.feed.FeedLike
import work.socialhub.kbsky.model.app.bsky.feed.FeedPost
import work.socialhub.kbsky.model.app.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.app.bsky.graph.GraphBlock
import work.socialhub.kbsky.model.app.bsky.graph.GraphFollow
import work.socialhub.kbsky.model.app.bsky.graph.GraphList
import work.socialhub.kbsky.model.app.bsky.graph.GraphListItem
import work.socialhub.kbsky.util.json.RecordPolymorphicSerializer

/**
 * @see ActorProfile
 * @see GraphFollow
 * @see GraphBlock
 * @see FeedLike
 * @see FeedPost
 * @see FeedRepost
 * @see GraphListItem
 * @see GraphList
 */
@Serializable(with = RecordPolymorphicSerializer::class)
abstract class RecordUnion {
    @SerialName("\$type")
    abstract var type: String

    val asActorProfile get() = this as? work.socialhub.kbsky.model.app.bsky.actor.ActorProfile
    val asGraphFollow get() = this as? work.socialhub.kbsky.model.app.bsky.graph.GraphFollow
    val asGraphBlock get() = this as? work.socialhub.kbsky.model.app.bsky.graph.GraphBlock
    val asFeedLike get() = this as? work.socialhub.kbsky.model.app.bsky.feed.FeedLike
    val asFeedPost get() = this as? work.socialhub.kbsky.model.app.bsky.feed.FeedPost
    val asFeedRepost get() = this as? work.socialhub.kbsky.model.app.bsky.feed.FeedRepost
    val asGraphListItem get() = this as? work.socialhub.kbsky.model.app.bsky.graph.GraphListItem
    val asGraphList get() = this as? work.socialhub.kbsky.model.app.bsky.graph.GraphList
}
