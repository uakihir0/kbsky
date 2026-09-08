package work.socialhub.kbsky.model.app.bsky.unspecced


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class UnspeccedDefsThreadItemNotFound(
    @SerialName("\$type")
    override var type: String = TYPE,
) : UnspeccedDefsThreadItemUnion() {
    companion object {
        val TYPE = BlueskyTypes.UnspeccedDefs + "#threadItemNotFound"
    }
}
