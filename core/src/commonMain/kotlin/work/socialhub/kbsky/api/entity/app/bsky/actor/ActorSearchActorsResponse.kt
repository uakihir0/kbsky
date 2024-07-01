package work.socialhub.kbsky.api.entity.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
class ActorSearchActorsResponse {
    var cursor: String? = null
    lateinit var actors: List<ActorDefsProfileView>
}
