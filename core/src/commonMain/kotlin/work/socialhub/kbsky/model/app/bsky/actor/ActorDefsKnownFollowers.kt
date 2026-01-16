package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsKnownFollowers(
    val count: Int = 0,
    var followers: List<ActorDefsProfileViewBasic> = emptyList(),
)
