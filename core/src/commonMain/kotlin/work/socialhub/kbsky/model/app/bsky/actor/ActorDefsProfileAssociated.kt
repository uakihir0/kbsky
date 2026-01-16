package work.socialhub.kbsky.model.app.bsky.actor

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ActorDefsProfileAssociated(
    var lists: Int? = null,
    var feedgens: Int? = null,
    var labeler: Boolean? = null,
    var chat: ActorDefsProfileAssociatedChat? = null,
)
