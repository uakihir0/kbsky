package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.Serializable

@Serializable
data class EmbedDefsAspectRatio(
    var width: Int = 1,
    var height: Int = 1
)
