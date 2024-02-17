package work.socialhub.kbsky.api.entity.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.graph.GraphDefsListView

@Serializable
class GraphGetListsResponse {
    var cursor: String? = null
    lateinit var lists: List<GraphDefsListView>
}
