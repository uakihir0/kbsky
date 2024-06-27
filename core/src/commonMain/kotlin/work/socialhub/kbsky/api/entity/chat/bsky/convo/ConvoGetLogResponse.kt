package work.socialhub.kbsky.api.entity.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.convo.ChatConvoDefsLogUnion

@Serializable
class ConvoGetLogResponse {
    lateinit var logs: List<ChatConvoDefsLogUnion>
}
