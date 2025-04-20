package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable

@Serializable
data class ConvoDefsMessageViewSender(
    var did: String,
)