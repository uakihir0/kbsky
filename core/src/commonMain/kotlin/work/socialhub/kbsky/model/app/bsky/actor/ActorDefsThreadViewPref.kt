package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsThreadViewPref : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#threadViewPref"
    }

    @SerialName("\$type")
    override var type = TYPE

    /**
     * Sorting mode for threads.
     * ["oldest", "newest", "most-likes", "random"]
     */
    var sort: String? = null

    /** Show followed users at the top of all replies. */
    var prioritizeFollowedUsers: Boolean? = null
}