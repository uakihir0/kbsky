package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class EmbedImagesView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var images: List<EmbedImagesViewImage>? = null,
) : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedImages + "#view"
    }
}
