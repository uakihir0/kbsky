package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A representation of some externally linked content, embedded in another form of content
 */
@Serializable
class EmbedExternal : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal
    }

    override var type: String = TYPE

    var external: EmbedExternalExternal? = null
}
