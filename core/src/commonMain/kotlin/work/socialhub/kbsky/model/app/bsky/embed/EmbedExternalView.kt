package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class EmbedExternalView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var external: EmbedExternalViewExternal? = null,
) : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal + "#view"
    }
}
