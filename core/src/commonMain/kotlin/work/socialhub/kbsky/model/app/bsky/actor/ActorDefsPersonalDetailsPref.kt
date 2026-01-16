package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsPersonalDetailsPref(
    @SerialName("\$type")
    override var type: String = TYPE,
    /** The birth date of account owner. */
    var birthDate: String? = null,
) : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#personalDetailsPref"
    }
}
