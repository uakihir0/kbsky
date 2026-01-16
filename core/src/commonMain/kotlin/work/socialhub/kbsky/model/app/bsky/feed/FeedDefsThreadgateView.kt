package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListViewBasic
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsThreadgateView(
    var uri: String? = null,
    var cid: String? = null,
    var record: FeedThreadgate? = null,
    var lists: List<GraphDefsListViewBasic>? = null,
)
