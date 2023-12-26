package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.EmbedViewPolymorphicSerializer

/**
 * @see EmbedExternalView
 * @see EmbedImagesView
 * @see EmbedRecordView
 * @see EmbedRecordWithMediaView
 */
@Serializable(with = EmbedViewPolymorphicSerializer::class)
abstract class EmbedViewUnion {
    @SerialName("\$type")
    abstract var type: String
}
