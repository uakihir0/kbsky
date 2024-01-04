package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsPersonalDetailsPref : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#personalDetailsPref"
    }

    @SerialName("\$type")
    override var type = TYPE

    /** The birth date of account owner. */
    var birthDate: String? = null
}