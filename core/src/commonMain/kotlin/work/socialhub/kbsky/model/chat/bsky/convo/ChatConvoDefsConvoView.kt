package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.actor.ChatActorDefsProfileViewBasic

/**
 * chat.bsky.convo.defs#convoView
 */
@Serializable
class ChatConvoDefsConvoView {
    lateinit var id: String
    lateinit var rev: String
    lateinit var members: List<ChatActorDefsProfileViewBasic>
    var lastMessage: ChatConvoDefsMessageUnion? = null
    var muted: Boolean = false
    var unreadCount: Int = 0
}
