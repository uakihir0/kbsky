package work.socialhub.kbsky.api.entity.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileViewDetailed

@Serializable
class ActorGetProfilesResponse {
    var profiles: List<ActorDefsProfileViewDetailed>? = null
}
