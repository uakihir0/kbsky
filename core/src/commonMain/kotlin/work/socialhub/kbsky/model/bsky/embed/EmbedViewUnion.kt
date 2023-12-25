package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName

/**
 * @see EmbedExternalView
 * @see EmbedImagesView
 * @see EmbedRecordView
 * @see EmbedRecordWithMediaView
 */
interface EmbedViewUnion {
    @SerialName("\$type")
    val type: String
}
