package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ConvoDefsLogBeginConvo : ConvoDefsLogUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#logBeginConvo"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var rev: String
    lateinit var convoId: String
}
