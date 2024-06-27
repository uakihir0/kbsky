package work.socialhub.kbsky.model.chat.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ChatConvoDefsLogDeleteMessage : ChatConvoDefsLogUnion() {

    companion object {
        const val TYPE = ChatTypes.ConvoDefs + "#logDeleteMessage"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var rev: String
    lateinit var convoId: String
    lateinit var message: ChatConvoDefsMessageUnion
}
