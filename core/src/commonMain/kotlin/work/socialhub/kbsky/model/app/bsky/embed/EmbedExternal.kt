package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A representation of some externally linked content, embedded in another form of content
 */
@Serializable
data class EmbedExternal(
    @SerialName("\$type")
    override var type: String = TYPE,
    var external: EmbedExternalExternal? = null,
) : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null)
}
