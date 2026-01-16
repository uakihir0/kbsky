package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.EmbedViewPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see EmbedExternalView
 * @see EmbedImagesView
 * @see EmbedVideoView
 * @see EmbedRecordView
 * @see EmbedRecordWithMediaView
 */
@Serializable(with = EmbedViewPolymorphicSerializer::class)
@JsExport
abstract class EmbedViewUnion {
    @SerialName("\$type")
    abstract var type: String

    val asExternal get() = this as? EmbedExternalView
    val asImages get() = this as? EmbedImagesView
    val asVideo get() = this as? EmbedVideoView
    val asRecord get() = this as? EmbedRecordView
    val asRecordWithMedia get() = this as? EmbedRecordWithMediaView
}
