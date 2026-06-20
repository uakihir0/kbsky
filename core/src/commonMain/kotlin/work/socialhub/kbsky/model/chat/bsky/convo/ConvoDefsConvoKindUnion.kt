package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatConvoDefsConvoKindUnionSerializer
import kotlin.js.JsExport

/**
 * The kind field of chat.bsky.convo.defs#convoView
 *
 * @see ConvoDefsGroupConvo
 * @see ConvoDefsDirectConvo
 */
@Serializable(with = ChatConvoDefsConvoKindUnionSerializer::class)
@JsExport
abstract class ConvoDefsConvoKindUnion {
    @SerialName("\$type")
    abstract val type: String

    val asGroupConvo get() = this as? ConvoDefsGroupConvo
    val asDirectConvo get() = this as? ConvoDefsDirectConvo
}
