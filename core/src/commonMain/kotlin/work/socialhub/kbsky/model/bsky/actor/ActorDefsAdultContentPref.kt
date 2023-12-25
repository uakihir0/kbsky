package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsAdultContentPref : ActorDefsPreferencesUnion {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#adultContentPref"
    }

    override val type = TYPE

    var enabled: Boolean? = null
}
