package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#convoView
 */
@Serializable
@JsExport
data class ConvoDefsConvoView(
    val id: String,
    val rev: String,
    // For groups, only the important members rather than all of them. Use getConvoMembers for the full list.
    val members: List<ActorDefsProfileViewBasic>,
    val lastMessage: ConvoDefsMessageUnion? = null,
    val lastReaction: ConvoDefsMessageAndReactionView? = null,
    val muted: Boolean = false,
    // chat.bsky.convo.defs#convoStatus ("request" / "accepted"), viewer perspective, optional
    val status: String? = null,
    // Union identifying direct / group (optional)
    val kind: ConvoDefsConvoKindUnion? = null,
    val unreadCount: Int = 0,
)
