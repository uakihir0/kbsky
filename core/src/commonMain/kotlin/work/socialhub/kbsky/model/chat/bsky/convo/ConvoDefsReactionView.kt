package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#reactionView
 */
@Serializable
@JsExport
data class ConvoDefsReactionView(
    val value: String,
    val sender: ConvoDefsReactionViewSender,
    val createdAt: String,
)
