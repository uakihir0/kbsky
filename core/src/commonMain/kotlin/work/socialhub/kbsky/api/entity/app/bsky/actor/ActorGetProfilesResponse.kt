package work.socialhub.kbsky.api.entity.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewDetailed

@Serializable
@JsExport
data class ActorGetProfilesResponse(
    var profiles: List<ActorDefsProfileViewDetailed> = emptyList(),
)
