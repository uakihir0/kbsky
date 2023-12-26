package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedExternalView : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal + "#view"
    }

    override var type = TYPE

    private var external: EmbedExternalViewExternal? = null
}
