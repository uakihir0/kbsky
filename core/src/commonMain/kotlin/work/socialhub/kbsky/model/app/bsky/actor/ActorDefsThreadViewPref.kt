package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class ActorDefsThreadViewPref(
    @SerialName("\$type")
    override var type: String = TYPE,
    /**
     * Sorting mode for threads.
     * ["oldest", "newest", "most-likes", "random"]
     */
    var sort: String? = null,
    /** Show followed users at the top of all replies. */
    var prioritizeFollowedUsers: Boolean? = null,
) : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#threadViewPref"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null, null)
}