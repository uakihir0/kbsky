package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsPersonalDetailsPref : work.socialhub.kbsky.model.app.bsky.actor.ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#personalDetailsPref"
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.actor.ActorDefsPersonalDetailsPref.Companion.TYPE

    /** The birth date of account owner. */
    var birthDate: String? = null
}