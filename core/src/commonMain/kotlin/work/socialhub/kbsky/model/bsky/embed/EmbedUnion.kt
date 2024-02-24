package work.socialhub.kbsky.model.bsky.embed

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

    val asExternal get() = this as? EmbedExternal
    val asImages get() = this as? EmbedImages
    val asRecord get() = this as? EmbedRecord
    val asRecordWithMedia get() = this as? EmbedRecordWithMedia
}
