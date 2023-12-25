package work.socialhub.kbsky.api.entity.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView

@Serializable
class ActorSearchActorsResponse {
    var cursor: String? = null
    var actors: List<ActorDefsProfileView>? = null
}
