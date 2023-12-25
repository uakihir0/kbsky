package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.Blob

@Serializable
class EmbedImagesImage {
    var image: Blob? = null
    var alt: String? = null
}
