package work.socialhub.kbsky.model.share


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class BlobRef(
    @SerialName("\$link")
    var link: String? = null,
)
