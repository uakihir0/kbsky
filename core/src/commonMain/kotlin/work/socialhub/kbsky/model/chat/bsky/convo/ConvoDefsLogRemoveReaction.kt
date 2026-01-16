package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoDefsLogRemoveReaction(
    @SerialName("\$type")
    override val type: String = TYPE,
    val rev: String,
    val convoId: String,
    val message: ConvoDefsMessageUnion,
    val reaction: ConvoDefsReactionView,
) : ConvoDefsLogUnion() {
    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#logRemoveReaction"
    }
}
