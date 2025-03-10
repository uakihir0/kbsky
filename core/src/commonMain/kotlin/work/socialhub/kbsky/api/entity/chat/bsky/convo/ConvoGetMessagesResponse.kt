package work.socialhub.kbsky.api.entity.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsMessageUnion

@Serializable
data class ConvoGetMessagesResponse(
    var cursor: String? = null,
    var messages: List<ConvoDefsMessageUnion>
)
