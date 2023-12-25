package work.socialhub.kbsky.api.entity.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetFollowsResponse {
    var subject: ActorDefsProfileView? = null
    var cursor: String? = null
    var follows: List<ActorDefsProfileView>? = null
}
