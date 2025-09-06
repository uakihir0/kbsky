package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
data class FeedDefsViewerState(
    var repost: String? = null,
    var like: String? = null,
    var bookmarked: Boolean? = null,
    var replyDisabled: Boolean? = null,
    var embeddingDisabled: Boolean? = null,
    var pinned: Boolean? = null,
)
