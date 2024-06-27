package work.socialhub.kbsky.model.chat.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatConvoDefsMessageUnionSerializer

/**
 * @see ChatConvoDefsMessageView
 * @see ChatConvoDefsDeletedMessageView
 */
@Serializable(with = ChatConvoDefsMessageUnionSerializer::class)
abstract class ChatConvoDefsMessageUnion {
    @SerialName("\$type")
    abstract var type: String

    val asMessageView get() = this as? ChatConvoDefsMessageView
    val asDeletedMessageView get() = this as? ChatConvoDefsDeletedMessageView
}
