package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class EmbedRecordViewDetached(
    @SerialName("\$type")
    override var type: String = TYPE,
    var uri: String? = null,
    var detached: Boolean = true,
) : EmbedRecordViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#viewDetached"
    }
}
