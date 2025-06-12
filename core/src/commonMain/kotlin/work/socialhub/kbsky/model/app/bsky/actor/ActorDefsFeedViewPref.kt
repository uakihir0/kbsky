package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class ActorDefsFeedViewPref(
    @SerialName("\$type")
    override var type: String = TYPE,
    /** The URI of the feed, or an identifier which describes the feed. */
    var feed: String = "",
    /** Hide replies in the feed. */
    var hideReplies: Boolean? = null,
    /** Hide replies in the feed if they are not by followed users. */
    var hideRepliesByUnfollowed: Boolean? = null,
    /** Hide replies in the feed if they do not have this number of likes. */
    var hideRepliesByLikeCount: Int? = null,
    /**　Hide reposts in the feed. */
    var hideReposts: Boolean? = null,
    /** Hide quote posts in the feed. */
    var hideQuotePosts: Boolean? = null,
) : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#feedViewPref"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, "", null, null, null, null, null)
}