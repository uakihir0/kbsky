package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ConvoDefsLogDeleteMessage : ConvoDefsLogUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#logDeleteMessage"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var rev: String
    lateinit var convoId: String
    lateinit var message: ConvoDefsMessageUnion
}
