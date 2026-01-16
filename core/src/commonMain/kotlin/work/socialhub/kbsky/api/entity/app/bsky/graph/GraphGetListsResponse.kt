package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView

@Serializable
@JsExport
data class GraphGetListsResponse(
    var cursor: String? = null,
    var lists: List<GraphDefsListView> = emptyList(),
)
