package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsContentLabelPref : ActorDefsPreferencesUnion {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#contentLabelPref"
    }

    override val type = TYPE
    var label: String? = null

    /**
     * ["show", "warn", "hide"]
     */
    var visibility: String? = null
}
