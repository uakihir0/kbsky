package work.socialhub.kbsky.model.chat.bsky.group


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic
import kotlin.js.JsExport

/**
 * chat.bsky.group.defs#joinRequestConvoView
 *
 * Join request from the requester's perspective
 */
@Serializable
@JsExport
data class GroupDefsJoinRequestConvoView(
    val convoId: String,
    val name: String,
    val owner: ActorDefsProfileViewBasic,
    val memberCount: Int,
    val memberLimit: Int,
    val viewer: GroupDefsJoinLinkViewerState,
)
