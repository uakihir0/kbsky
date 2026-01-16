package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsSavedFeed(
    val id: String = "",
    // knownValues: ['feed', 'list', 'timeline']
    val type: String = "",
    val value: String = "",
    val pinned: Boolean = false,
)
