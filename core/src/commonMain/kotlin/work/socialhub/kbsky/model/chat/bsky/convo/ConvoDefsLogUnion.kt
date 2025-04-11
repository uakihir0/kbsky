package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatConvoDefsLogUnionSerializer

/**
 * @see ConvoDefsLogBeginConvo
 * @see ConvoDefsLogLeaveConvo
 * @see ConvoDefsLogCreateMessage
 * @see ConvoDefsLogDeleteMessage
 */
@Serializable(with = ChatConvoDefsLogUnionSerializer::class)
abstract class ConvoDefsLogUnion {
    @SerialName("\$type")
    abstract val type: String

    val asBeginConvo get() = this as? ConvoDefsLogBeginConvo
    val asLeaveConvo get() = this as? ConvoDefsLogLeaveConvo
    val asCreateMessage get() = this as? ConvoDefsLogCreateMessage
    val asDeleteMessage get() = this as? ConvoDefsLogDeleteMessage
}
