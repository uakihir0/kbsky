package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatConvoDefsMessageUnionSerializer
import kotlin.js.JsExport

/**
 * @see ConvoDefsMessageView
 * @see ConvoDefsDeletedMessageView
 */
@Serializable(with = ChatConvoDefsMessageUnionSerializer::class)
@JsExport
abstract class ConvoDefsMessageUnion {
    @SerialName("\$type")
    abstract val type: String

    val asMessageView get() = this as? ConvoDefsMessageView
    val asDeletedMessageView get() = this as? ConvoDefsDeletedMessageView
}
