package work.socialhub.kbsky.api.entity.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetFollowersResponse {
    var cursor: String? = null
    lateinit var subject: ActorDefsProfileView
    lateinit var followers: List<ActorDefsProfileView>
}
