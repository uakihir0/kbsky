package work.socialhub.kbsky.api.entity.chat.bsky.convo


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoAcceptConvoResponse(
    var rev: String? = null
)
