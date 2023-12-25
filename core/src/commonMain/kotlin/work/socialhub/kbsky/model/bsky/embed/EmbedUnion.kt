package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName

/**
 * @see EmbedExternal
 * @see EmbedImages
 * @see EmbedRecord
 * @see EmbedRecordWithMedia
 */
interface EmbedUnion {
    @SerialName("\$type")
    var type: String
}
