package work.socialhub.kbsky.api.entity.bsky.graph

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class GraphGetMutesResponse {
    var cursor: String? = null
    lateinit var mutes: List<ActorDefsProfileView>
}
