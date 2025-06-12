package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class EmbedExternalView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var external: EmbedExternalViewExternal? = null,
) : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal + "#view"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null)
}
