package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedExternalView : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal + "#view"
    }

    @SerialName("\$type")
    override var type = TYPE

    var external: EmbedExternalViewExternal? = null
}
