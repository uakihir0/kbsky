package work.socialhub.kbsky.api.entity.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewDetailed

@Serializable
class ActorGetProfilesResponse {
    lateinit var profiles: List<ActorDefsProfileViewDetailed>
}
