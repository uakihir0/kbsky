package work.socialhub.kbsky.api.entity.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsPreferencesUnion

@Serializable
class ActorGetPreferencesResponse {
    var preferences: List<ActorDefsPreferencesUnion>? = null
}
