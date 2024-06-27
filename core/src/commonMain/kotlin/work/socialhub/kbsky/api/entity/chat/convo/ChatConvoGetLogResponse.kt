package work.socialhub.kbsky.api.entity.chat.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.convo.ChatConvoDefsLogUnion

@Serializable
class ChatConvoGetLogResponse {
    lateinit var logs: List<ChatConvoDefsLogUnion>
}
