package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.graph.GraphStarterPackView

@Serializable
data class GraphGetStarterPackResponse(
    var starterPack: GraphStarterPackView
)