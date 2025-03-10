package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class ConvoDefsLogDeleteMessage(
    @SerialName("\$type")
    override var type: String = TYPE,

    var rev: String,
    var convoId: String,
    var message: ConvoDefsMessageUnion
) : ConvoDefsLogUnion() {
    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#logDeleteMessage"
    }
}
