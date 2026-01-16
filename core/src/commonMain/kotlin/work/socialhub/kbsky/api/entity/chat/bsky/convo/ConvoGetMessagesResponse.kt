package work.socialhub.kbsky.api.entity.chat.bsky.convo


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsMessageUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoGetMessagesResponse(
    var cursor: String? = null,
    var messages: List<ConvoDefsMessageUnion>
)
