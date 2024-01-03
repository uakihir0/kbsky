package work.socialhub.kbsky.model.share

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorProfile
import work.socialhub.kbsky.model.bsky.feed.FeedLike
import work.socialhub.kbsky.model.bsky.feed.FeedPost
import work.socialhub.kbsky.model.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.bsky.graph.GraphBlock
import work.socialhub.kbsky.model.bsky.graph.GraphFollow
import work.socialhub.kbsky.util.json.RecordPolymorphicSerializer

/**
 * @see ActorProfile
 * @see GraphFollow
 * @see GraphBlock
 * @see FeedLike
 * @see FeedPost
 * @see FeedRepost
 */
@Serializable(with = RecordPolymorphicSerializer::class)
abstract class RecordUnion {
    @SerialName("\$type")
    abstract var type: String

    fun actorProfile(): ActorProfile? = this as? ActorProfile
    fun graphFollow(): GraphFollow? = this as? GraphFollow
    fun graphBlock(): GraphBlock? = this as? GraphBlock
    fun feedLike(): FeedLike? = this as? FeedLike
    fun feedPost(): FeedPost? = this as? FeedPost
    fun feedRepost(): FeedRepost? = this as? FeedRepost
}
