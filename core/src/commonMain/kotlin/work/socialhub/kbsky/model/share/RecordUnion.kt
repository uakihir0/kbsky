package work.socialhub.kbsky.model.share

import kotlinx.serialization.SerialName

/**
 * @see work.socialhub.kbsky.model.bsky.actor.ActorProfile
 * @see work.socialhub.kbsky.model.bsky.graph.GraphFollow
 * @see work.socialhub.kbsky.model.bsky.graph.GraphBlock
 * @see work.socialhub.kbsky.model.bsky.feed.FeedLike
 * @see work.socialhub.kbsky.model.bsky.feed.FeedPost
 * @see work.socialhub.kbsky.model.bsky.feed.FeedRepost
 */
interface RecordUnion {
    @SerialName("\$type")
    var type: String
}
