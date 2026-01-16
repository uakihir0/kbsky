package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoDefsMessageAndReactionView(
    @SerialName("\$type")
    val type: String = TYPE,
    val message: ConvoDefsMessageView,
    val reaction: ConvoDefsReactionView,
) {
    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#messageAndReactionView"
    }
}
