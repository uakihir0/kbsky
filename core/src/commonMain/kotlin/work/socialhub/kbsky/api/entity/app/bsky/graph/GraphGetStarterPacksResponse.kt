package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsStarterPackViewBasic

@Serializable
data class GraphGetStarterPacksResponse(
    var starterPacks: List<GraphDefsStarterPackViewBasic>
)
