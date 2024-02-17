package work.socialhub.kbsky.api.entity.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.graph.GraphDefsListItemView
import work.socialhub.kbsky.model.bsky.graph.GraphDefsListView

@Serializable
class GraphGetListResponse {
    var cursor: String? = null
    lateinit var list: GraphDefsListView
    lateinit var items: List<GraphDefsListItemView>
}
