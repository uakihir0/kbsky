package work.socialhub.kbsky.model.share

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Blob {

    @SerialName("\$type")
    var type = "blob"
    var ref: BlobRef? = null
    var mimeType: String? = null
    var size: Int? = null
}
