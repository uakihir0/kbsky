package work.socialhub.kbsky.api.entity.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetBlocksResponse {
    var cursor: String? = null
    lateinit var blocks: List<ActorDefsProfileView>
}
