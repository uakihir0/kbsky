package work.socialhub.kbsky.api.entity.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetBlocksResponse {
    var cursor: String? = null
    var blocks: List<ActorDefsProfileView>? = null
}
