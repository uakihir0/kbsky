package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class ConvoDefsMessageAndReactionView(
    @SerialName("\$type")
    override val type: String = TYPE,
    val message: ConvoDefsMessageView,
    val reaction: ConvoDefsReactionView,
) : ConvoDefsMessageUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#messageAndReactionView"
    }
}
