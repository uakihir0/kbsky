package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsSavedFeedsPref : ActorDefsPreferencesUnion {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#savedFeedsPref"
    }

    override val type = TYPE

    /** at-url  */
    var pinned: List<String>? = null

    /** at-url  */
    var saved: List<String>? = null
}
