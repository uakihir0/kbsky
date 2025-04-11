package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable

/**
 * chat.bsky.convo.defs#reactionView
 */
@Serializable
data class ConvoDefsReactionView(
    val value: String,
    val sender: ConvoDefsReactionViewSender,
    val createdAt: String,
)