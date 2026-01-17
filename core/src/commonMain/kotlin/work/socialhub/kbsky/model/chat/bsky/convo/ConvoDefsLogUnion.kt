package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatConvoDefsLogUnionSerializer
import kotlin.js.JsExport

/**
 * @see ConvoDefsLogBeginConvo
 * @see ConvoDefsLogLeaveConvo
 * @see ConvoDefsLogCreateMessage
 * @see ConvoDefsLogDeleteMessage
 * @see ConvoDefsLogReadMessage
 * @see ConvoDefsLogAddReaction
 * @see ConvoDefsLogRemoveReaction
 */
@Serializable(with = ChatConvoDefsLogUnionSerializer::class)
@JsExport
abstract class ConvoDefsLogUnion {
    @SerialName("\$type")
    abstract val type: String

    val asBeginConvo get() = this as? ConvoDefsLogBeginConvo
    val asLeaveConvo get() = this as? ConvoDefsLogLeaveConvo
    val asCreateMessage get() = this as? ConvoDefsLogCreateMessage
    val asDeleteMessage get() = this as? ConvoDefsLogDeleteMessage
    val asReadMessage get() = this as? ConvoDefsLogReadMessage
    val asAddReaction get() = this as? ConvoDefsLogAddReaction
    val asRemoveReaction get() = this as? ConvoDefsLogRemoveReaction
}
