package work.socialhub.kbsky.api.entity.app.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetMutesResponse {
    var cursor: String? = null
    lateinit var mutes: List<ActorDefsProfileView>
}
