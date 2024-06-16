package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.graph.GraphDefsListViewBasic

@Serializable
class FeedDefsThreadgateView {
    var uri: String? = null
    var cid: String? = null
    var record: Threadgate? = null
    var lists: List<GraphDefsListViewBasic>? = null
}
