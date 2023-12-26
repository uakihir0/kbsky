package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.EmbedRecordViewPolymorphicSerializer

/**
 * @see EmbedRecordViewRecord
 * @see EmbedRecordViewNotFound
 * @see EmbedRecordViewBlocked
 */
@Serializable(with = EmbedRecordViewPolymorphicSerializer::class)
abstract class EmbedRecordViewUnion {
    @SerialName("\$type")
    abstract var type: String
}
