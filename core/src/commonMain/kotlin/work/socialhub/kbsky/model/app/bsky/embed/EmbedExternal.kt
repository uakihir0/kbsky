package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A representation of some externally linked content, embedded in another form of content
 */
@Serializable
class EmbedExternal : work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedExternal
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.embed.EmbedExternal.Companion.TYPE

    var external: work.socialhub.kbsky.model.app.bsky.embed.EmbedExternalExternal? = null
}
