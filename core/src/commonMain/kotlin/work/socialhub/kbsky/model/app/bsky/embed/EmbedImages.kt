package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * A set of images embedded in some other form of content
 */
@Serializable
@JsExport
data class EmbedImages(
    @SerialName("\$type")
    override var type: String = TYPE,
    var images: List<EmbedImagesImage>? = null,
) : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedImages
    }
}
