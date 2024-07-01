package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListItemView
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView

@Serializable
class GraphGetListResponse {
    var cursor: String? = null
    lateinit var list: GraphDefsListView
    lateinit var items: List<GraphDefsListItemView>
}
