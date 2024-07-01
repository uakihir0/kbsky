package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic

/**
 * chat.bsky.convo.defs#convoView
 */
@Serializable
class ConvoDefsConvoView {
    lateinit var id: String
    lateinit var rev: String
    lateinit var members: List<ActorDefsProfileViewBasic>
    var lastMessage: ConvoDefsMessageUnion? = null
    var muted: Boolean = false
    var unreadCount: Int = 0
}
