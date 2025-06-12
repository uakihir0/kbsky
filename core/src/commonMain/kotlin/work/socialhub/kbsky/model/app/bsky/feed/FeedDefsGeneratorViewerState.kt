package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
data class FeedDefsGeneratorViewerState(
    /** at-url  */
    var like: String? = null,
)
