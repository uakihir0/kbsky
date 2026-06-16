package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#systemMessageDataRemoveMember
 */
@Serializable
@JsExport
data class ConvoDefsSystemMessageDataRemoveMember(
    @SerialName("\$type")
    override val type: String = TYPE,
    val member: ConvoDefsSystemMessageReferredUser,
    val removedBy: ConvoDefsSystemMessageReferredUser,
) : ConvoDefsSystemMessageDataUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#systemMessageDataRemoveMember"
    }
}
