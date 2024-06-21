package work.socialhub.kbsky.api.entity.chat.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.convo.ChatConvoDefsConvoView

@Serializable
class ChatConvoGetConvoResponse {
    lateinit var convo: ChatConvoDefsConvoView
}
