package work.socialhub.kbsky.api.entity.chat.convo

import kotlinx.serialization.Serializable

@Serializable
class ChatConvoLeaveConvoResponse {
    lateinit var convoId: String
    lateinit var rev: String
}
