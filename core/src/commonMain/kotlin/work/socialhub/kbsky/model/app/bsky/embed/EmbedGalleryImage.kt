package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.Blob
import kotlin.js.JsExport

/**
 * The `items` of a gallery is a union type, so each element requires
 * a `$type` discriminator.
 */
@Serializable
@JsExport
data class EmbedGalleryImage(
    @SerialName("\$type")
    var type: String = TYPE,
    var image: Blob? = null,
    var alt: String? = null,
    var aspectRatio: EmbedDefsAspectRatio? = null,
) {

    companion object {
        const val TYPE = BlueskyTypes.EmbedGallery + "#image"
    }
}
