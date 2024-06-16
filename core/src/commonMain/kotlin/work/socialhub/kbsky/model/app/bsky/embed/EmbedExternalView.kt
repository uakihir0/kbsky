package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedExternalView : work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal + "#view"
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.embed.EmbedExternalView.Companion.TYPE

    var external: work.socialhub.kbsky.model.app.bsky.embed.EmbedExternalViewExternal? = null
}
