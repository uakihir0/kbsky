package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.EmbedPolymorphicSerializer
import kotlin.js.JsExport

/**
 * @see EmbedExternal
 * @see EmbedImages
 * @see EmbedVideo
 * @see EmbedRecord
 * @see EmbedRecordWithMedia
 */
@Serializable(with = EmbedPolymorphicSerializer::class)
@JsExport
abstract class EmbedUnion {
    @SerialName("\$type")
    abstract var type: String

    val asExternal get() = this as? EmbedExternal
    val asImages get() = this as? EmbedImages
    val asVideo get() = this as? EmbedVideo
    val asRecord get() = this as? EmbedRecord
    val asRecordWithMedia get() = this as? EmbedRecordWithMedia
}
