package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#systemMessageDataEditJoinLink
 */
@Serializable
@JsExport
data class ConvoDefsSystemMessageDataEditJoinLink(
    @SerialName("\$type")
    override val type: String = TYPE,
) : ConvoDefsSystemMessageDataUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#systemMessageDataEditJoinLink"
    }
}
