package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#systemMessageView
 *
 * Union member of convoView.lastMessage / getMessages
 */
@Serializable
@JsExport
data class ConvoDefsSystemMessageView(
    @SerialName("\$type")
    override val type: String = TYPE,
    val id: String,
    val rev: String,
    val sentAt: String,
    val data: ConvoDefsSystemMessageDataUnion,
) : ConvoDefsMessageUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#systemMessageView"
    }
}
