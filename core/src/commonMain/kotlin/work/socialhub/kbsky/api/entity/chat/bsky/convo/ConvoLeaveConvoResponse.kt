package work.socialhub.kbsky.api.entity.chat.bsky.convo

import kotlinx.serialization.Serializable

@Serializable
class ConvoLeaveConvoResponse {
    lateinit var convoId: String
    lateinit var rev: String
}
