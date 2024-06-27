package work.socialhub.kbsky.model.chat.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ChatConvoDefsLogLeaveConvo : ChatConvoDefsLogUnion() {

    companion object {
        const val TYPE = ChatTypes.ConvoDefs + "#logLeaveConvo"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var rev: String
    lateinit var convoId: String
}
