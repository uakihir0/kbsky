package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * An assortment of media embedded in a Bluesky record (eg, a post).
 *
 * A separate data structure (app.bsky.embed.gallery) for 5 or more images
 * (up to 10). Use [EmbedImages] for up to 4 images.
 */
@Serializable
@JsExport
data class EmbedGallery(
    @SerialName("\$type")
    override var type: String = TYPE,
    var items: List<EmbedGalleryImage>? = null,
) : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedGallery
    }
}
