package work.socialhub.kbsky.api.entity.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

@Serializable
@JsExport
data class ActorSearchActorsResponse(
    var cursor: String? = null,
    var actors: List<ActorDefsProfileView> = emptyList(),
)
