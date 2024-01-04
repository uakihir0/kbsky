package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsAdultContentPref : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#adultContentPref"
    }

    @SerialName("\$type")
    override var type = TYPE

    var enabled: Boolean = false
}
