package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.Serializable

@Serializable
data class GraphDefsListViewerState(
    /** at-uri  */
    var repost: String? = null,

    /** at-uri  */
    var like: String? = null,

    var replyDisabled: Boolean? = null
)
