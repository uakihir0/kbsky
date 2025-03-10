package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
data class GraphGetFollowersResponse(
    var cursor: String? = null,
    var subject: ActorDefsProfileView,
    var followers: List<ActorDefsProfileView>
)
