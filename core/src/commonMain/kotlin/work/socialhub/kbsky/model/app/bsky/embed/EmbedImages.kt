package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A set of images embedded in some other form of content
 */
@Serializable
data class EmbedImages(
    @SerialName("\$type")
    override var type: String = TYPE,
    var images: List<EmbedImagesImage>? = null,
) : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedImages
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null)
}
