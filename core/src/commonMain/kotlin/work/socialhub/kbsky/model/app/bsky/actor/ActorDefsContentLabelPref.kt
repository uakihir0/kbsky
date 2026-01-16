package work.socialhub.kbsky.model.app.bsky.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsContentLabelPref(
    @SerialName("\$type")
    override var type: String = TYPE,
    var label: String = "",
    /** ["show", "warn", "hide"] */
    var visibility: String = "",
) : ActorDefsPreferencesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ActorDefs + "#contentLabelPref"
    }
}
