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

    fun `external`() = this as? EmbedExternal
    fun images() = this as? EmbedImages
    fun record() = this as? EmbedRecord
    fun recordWithMedia() = this as? EmbedRecordWithMedia
}
