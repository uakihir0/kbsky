package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * The `items` of a gallery#view is a union type, so each element requires
 * a `$type` discriminator.
 */
@Serializable
@JsExport
data class EmbedGalleryViewImage(
    @SerialName("\$type")
    val type: String = TYPE,
    val thumbnail: String? = null,
    val fullsize: String? = null,
    val alt: String? = null,
    val aspectRatio: EmbedDefsAspectRatio? = null,
) {

    companion object {
        const val TYPE = BlueskyTypes.EmbedGallery + "#viewImage"
    }
}
