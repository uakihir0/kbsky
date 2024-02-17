package work.socialhub.kbsky.model.bsky.graph

import kotlinx.serialization.Serializable

@Serializable
class GraphDefsListViewerState {

    /** at-uri  */
    var repost: String? = null

    /** at-uri  */
    var like: String? = null

    var replyDisabled: Boolean? = null
}
