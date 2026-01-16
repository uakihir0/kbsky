package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoDefsLogBeginConvo(
    @SerialName("\$type")
    override var type: String = TYPE,
    var rev: String,
    var convoId: String,
) : ConvoDefsLogUnion() {
    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#logBeginConvo"
    }
}
