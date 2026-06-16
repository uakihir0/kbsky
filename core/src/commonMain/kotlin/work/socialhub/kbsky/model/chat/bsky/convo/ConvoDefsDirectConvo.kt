package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#directConvo
 *
 * 1-on-1 direct message (no fields)
 */
@Serializable
@JsExport
data class ConvoDefsDirectConvo(
    @SerialName("\$type")
    override val type: String = TYPE,
) : ConvoDefsConvoKindUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#directConvo"
    }
}
