package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#replyRef
 *
 * Reply reference to a message
 */
@Serializable
@JsExport
data class ConvoDefsReplyRef(
    val messageId: String,
)
