package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.Serializable

@Serializable
data class EmbedExternalViewExternal(
    var uri: String,
    var title: String,
    var description: String,
    var thumb: String? = null
)
