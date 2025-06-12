package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.Blob

@Serializable
data class EmbedExternalExternal(
    var uri: String = "",
    var title: String = "",
    var description: String = "",
    var thumb: Blob? = null,
)
