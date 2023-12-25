package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName

/**
 * @see EmbedRecordViewRecord
 * @see EmbedRecordViewNotFound
 * @see EmbedRecordViewBlocked
 */
interface EmbedRecordViewUnion {
    @SerialName("\$type")
    val type: String
}
