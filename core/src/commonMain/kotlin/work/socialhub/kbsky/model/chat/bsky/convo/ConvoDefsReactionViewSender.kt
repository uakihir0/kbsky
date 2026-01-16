package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#reactionViewSender
 */
@Serializable
@JsExport
data class ConvoDefsReactionViewSender(
    val did: String,
)
