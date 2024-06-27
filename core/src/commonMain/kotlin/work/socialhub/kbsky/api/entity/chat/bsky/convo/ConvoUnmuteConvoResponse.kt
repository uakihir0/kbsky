package work.socialhub.kbsky.api.entity.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.convo.ChatConvoDefsConvoView

@Serializable
class ConvoUnmuteConvoResponse {
    lateinit var convo: ChatConvoDefsConvoView
}
