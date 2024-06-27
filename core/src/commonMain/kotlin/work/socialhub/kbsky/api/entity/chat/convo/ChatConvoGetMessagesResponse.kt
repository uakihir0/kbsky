package work.socialhub.kbsky.api.entity.chat.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.convo.ChatConvoDefsMessageUnion

@Serializable
class ChatConvoGetMessagesResponse {
    var cursor: String? = null
    lateinit var messages: List<ChatConvoDefsMessageUnion>
}
