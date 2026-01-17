package work.socialhub.kbsky.api.entity.chat.bsky.convo


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoLeaveConvoResponse(
    var convoId: String,
    var rev: String
)
