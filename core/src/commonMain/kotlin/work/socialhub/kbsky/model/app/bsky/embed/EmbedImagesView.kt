package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedImagesView : work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedImages + "#view"
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.embed.EmbedImagesView.Companion.TYPE

    var images: List<work.socialhub.kbsky.model.app.bsky.embed.EmbedImagesViewImage>? = null
}
