package work.socialhub.kbsky.model.chat.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.ChatTypes

@Serializable
class ChatConvoDefsDeletedMessageView : ChatConvoDefsMessageUnion() {

    companion object {
        const val TYPE = ChatTypes.ConvoDefs + "#deletedMessageView"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var id: String
    lateinit var rev: String
    lateinit var sender: ChatConvoDefsMessageViewSender
    lateinit var sentAt: String
}
