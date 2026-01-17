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
    val members: List<ActorDefsProfileViewBasic>,
    val lastMessage: ConvoDefsMessageUnion? = null,
    val lastReaction: ConvoDefsMessageAndReactionView? = null,
    val muted: Boolean = false,
    val unreadCount: Int = 0,
)
