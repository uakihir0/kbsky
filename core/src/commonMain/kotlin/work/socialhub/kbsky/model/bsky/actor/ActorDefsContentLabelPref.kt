package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ActorDefsContentLabelPref : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#contentLabelPref"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var label: String

    /** ["show", "warn", "hide"] */
    lateinit var visibility: String
}
