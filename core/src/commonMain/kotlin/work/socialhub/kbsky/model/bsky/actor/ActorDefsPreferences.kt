package work.socialhub.kbsky.model.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
class ActorDefsPreferences {
    val items: List<ActorDefsPreferencesUnion>? = null
}
