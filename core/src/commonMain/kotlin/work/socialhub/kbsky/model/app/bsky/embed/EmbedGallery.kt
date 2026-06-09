package work.socialhub.kbsky.model.app.bsky.embed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * A gallery of media items embedded in some other form of content (up to 20 items)
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
