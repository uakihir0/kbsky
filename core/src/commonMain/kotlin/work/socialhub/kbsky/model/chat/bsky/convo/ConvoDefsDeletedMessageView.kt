package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class ConvoDefsDeletedMessageView(
    @SerialName("\$type")
    override var type: String = TYPE,

    var id: String,
    var rev: String,
    var sender: ConvoDefsMessageViewSender,
    var sentAt: String
) : ConvoDefsMessageUnion() {
    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#deletedMessageView"
    }
}
