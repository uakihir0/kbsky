package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable

@Serializable
class ActorDefsPreferences {
    val items: List<ActorDefsPreferencesUnion>? = null
}
