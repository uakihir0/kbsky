package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedImagesView : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedImages + "#view"
    }

    override var type = TYPE

    var images: List<EmbedImagesViewImage>? = null
}
