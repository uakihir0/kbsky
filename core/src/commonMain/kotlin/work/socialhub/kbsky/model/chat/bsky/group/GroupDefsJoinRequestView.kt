package work.socialhub.kbsky.model.chat.bsky.group


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic
import kotlin.js.JsExport

/**
 * chat.bsky.group.defs#joinRequestView
 *
 * Join request from the owner's perspective
 */
@Serializable
@JsExport
data class GroupDefsJoinRequestView(
    val convoId: String,
    val requestedBy: ActorDefsProfileViewBasic,
    val requestedAt: String,
)
