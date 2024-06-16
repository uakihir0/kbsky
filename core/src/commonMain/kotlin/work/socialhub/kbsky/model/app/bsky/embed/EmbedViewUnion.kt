package work.socialhub.kbsky.model.app.bsky.embed

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

    val asExternal get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedExternalView
    val asImages get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedImagesView
    val asRecord get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordView
    val asRecordWithMedia get() = this as? work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordWithMediaView
}
