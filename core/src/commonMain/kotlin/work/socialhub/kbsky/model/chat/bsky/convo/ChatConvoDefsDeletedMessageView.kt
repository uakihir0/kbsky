package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ChatConvoDefsDeletedMessageView : ChatConvoDefsMessageUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#deletedMessageView"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var id: String
    lateinit var rev: String
    lateinit var sender: ChatConvoDefsMessageViewSender
    lateinit var sentAt: String
}
