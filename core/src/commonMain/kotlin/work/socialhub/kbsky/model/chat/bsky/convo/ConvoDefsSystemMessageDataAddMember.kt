package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#systemMessageDataAddMember
 */
@Serializable
@JsExport
data class ConvoDefsSystemMessageDataAddMember(
    @SerialName("\$type")
    override val type: String = TYPE,
    val member: ConvoDefsSystemMessageReferredUser,
    // chat.bsky.actor.defs#memberRole ("owner" / "standard")
    val role: String,
    val addedBy: ConvoDefsSystemMessageReferredUser,
) : ConvoDefsSystemMessageDataUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#systemMessageDataAddMember"
    }
}
