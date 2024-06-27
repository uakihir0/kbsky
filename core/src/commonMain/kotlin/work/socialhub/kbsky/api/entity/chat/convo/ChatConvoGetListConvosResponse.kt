package work.socialhub.kbsky.api.entity.chat.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.convo.ChatConvoDefsConvoView

@Serializable
class ChatConvoGetListConvosResponse {
    var cursor: String? = null
    lateinit var convos: List<ChatConvoDefsConvoView>
}
