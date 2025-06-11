package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.Serializable

@Serializable
data class GraphDefsListViewerState(
    var repost: String? = null,
    var like: String? = null,
    var replyDisabled: Boolean? = null,
)
