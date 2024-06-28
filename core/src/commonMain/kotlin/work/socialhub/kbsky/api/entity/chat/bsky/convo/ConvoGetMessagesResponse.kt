package work.socialhub.kbsky.api.entity.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.convo.ChatConvoDefsMessageUnion

@Serializable
class ConvoGetMessagesResponse {
    var cursor: String? = null
    lateinit var messages: List<ChatConvoDefsMessageUnion>
}
