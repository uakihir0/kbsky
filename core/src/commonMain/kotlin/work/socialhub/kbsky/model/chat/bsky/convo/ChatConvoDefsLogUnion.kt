package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatConvoDefsLogUnionSerializer

/**
 * @see ChatConvoDefsLogBeginConvo
 * @see ChatConvoDefsLogLeaveConvo
 * @see ChatConvoDefsLogCreateMessage
 * @see ChatConvoDefsLogDeleteMessage
 */
@Serializable(with = ChatConvoDefsLogUnionSerializer::class)
abstract class ChatConvoDefsLogUnion {
    @SerialName("\$type")
    abstract var type: String

    val asBeginConvo get() = this as? ChatConvoDefsLogBeginConvo
    val asLeaveConvo get() = this as? ChatConvoDefsLogLeaveConvo
    val asCreateMessage get() = this as? ChatConvoDefsLogCreateMessage
    val asDeleteMessage get() = this as? ChatConvoDefsLogDeleteMessage
}
