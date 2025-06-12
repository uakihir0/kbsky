package work.socialhub.kbsky.api.entity.app.bsky.actor

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsPreferencesUnion

@Serializable
data class ActorGetPreferencesResponse(
    var preferences: List<ActorDefsPreferencesUnion> = emptyList(),
)
