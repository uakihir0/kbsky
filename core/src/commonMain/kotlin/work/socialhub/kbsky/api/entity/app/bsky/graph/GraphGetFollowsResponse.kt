package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetFollowsResponse {
    var cursor: String? = null
    lateinit var subject: work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
    lateinit var follows: List<work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView>
}
