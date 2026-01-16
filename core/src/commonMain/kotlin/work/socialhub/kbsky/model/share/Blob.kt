package work.socialhub.kbsky.model.share

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
data class Blob(
    @SerialName("\$type")
    var type: String = "blob",
    var ref: BlobRef? = null,
    var mimeType: String? = null,
    var size: Int? = null,
)
