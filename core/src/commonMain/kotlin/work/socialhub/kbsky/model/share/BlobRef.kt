package work.socialhub.kbsky.model.share

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BlobRef {

    @SerialName("\$link")
    var link: String? = null
}
