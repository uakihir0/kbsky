package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#systemMessageDataEditGroup
 */
@Serializable
@JsExport
data class ConvoDefsSystemMessageDataEditGroup(
    @SerialName("\$type")
    override val type: String = TYPE,
    val oldName: String? = null,
    val newName: String? = null,
) : ConvoDefsSystemMessageDataUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#systemMessageDataEditGroup"
    }
}
