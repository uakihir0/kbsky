package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.EmbedPolymorphicSerializer

/**
 * @see EmbedExternal
 * @see EmbedImages
 * @see EmbedRecord
 * @see EmbedRecordWithMedia
 */
@Serializable(with = EmbedPolymorphicSerializer::class)
abstract class EmbedUnion {
    @SerialName("\$type")
    abstract var type: String

    val asExternal get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedExternal
    val asImages get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedImages
    val asRecord get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedRecord
    val asRecordWithMedia get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordWithMedia
}
