package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsAdultContentPref : work.socialhub.kbsky.model.app.bsky.actor.ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#adultContentPref"
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.actor.ActorDefsAdultContentPref.Companion.TYPE

    var enabled: Boolean = false
}
