package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsPreferences(
    val items: List<ActorDefsPreferencesUnion>? = null,
)
