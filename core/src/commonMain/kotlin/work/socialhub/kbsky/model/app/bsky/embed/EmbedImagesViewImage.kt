package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.Serializable

@Serializable
data class EmbedImagesViewImage(
    var thumb: String? = null,
    var fullsize: String? = null,
    var alt: String? = null
)
