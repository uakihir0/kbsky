package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#systemMessageDataMemberLeave
 */
@Serializable
@JsExport
data class ConvoDefsSystemMessageDataMemberLeave(
    @SerialName("\$type")
    override val type: String = TYPE,
    val member: ConvoDefsSystemMessageReferredUser,
) : ConvoDefsSystemMessageDataUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#systemMessageDataMemberLeave"
    }
}
