package work.socialhub.kbsky.api.entity.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogUnion

@Serializable
@JsExport
data class ConvoGetLogResponse(
    var logs: List<ConvoDefsLogUnion>
)
