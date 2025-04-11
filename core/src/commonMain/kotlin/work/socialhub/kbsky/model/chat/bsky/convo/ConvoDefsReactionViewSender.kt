package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable

/**
 * chat.bsky.convo.defs#reactionViewSender
 */
@Serializable
data class ConvoDefsReactionViewSender(
    val did: String,
)
