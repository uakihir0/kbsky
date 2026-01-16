package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsStarterPackView

@Serializable
@JsExport
data class GraphGetStarterPackResponse(
    var starterPack: GraphDefsStarterPackView
)