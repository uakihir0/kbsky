package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetBlocksResponse {
    var cursor: String? = null
    lateinit var blocks: List<work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView>
}
