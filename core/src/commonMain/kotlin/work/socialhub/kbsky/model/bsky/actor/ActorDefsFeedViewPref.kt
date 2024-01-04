package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsFeedViewPref : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#feedViewPref"
    }

    @SerialName("\$type")
    override var type = TYPE

    /** The URI of the feed, or an identifier which describes the feed. */
    lateinit var feed: String

    /** Hide replies in the feed. */
    var hideReplies: Boolean? = null

    /** Hide replies in the feed if they are not by followed users. */
    var hideRepliesByUnfollowed: Boolean? = null

    /** Hide replies in the feed if they do not have this number of likes. */
    var hideRepliesByLikeCount: Int? = null

    /**　Hide reposts in the feed. */
    var hideReposts: Boolean? = null

    /** Hide quote posts in the feed. */
    var hideQuotePosts: Boolean? = null
}