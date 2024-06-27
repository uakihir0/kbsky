package work.socialhub.kbsky.model.chat.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.ChatTypes

@Serializable
class ChatConvoDefsLogBeginConvo : ChatConvoDefsLogUnion() {

    companion object {
        const val TYPE = ChatTypes.ConvoDefs + "#logBeginConvo"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var rev: String
    lateinit var convoId: String
}
