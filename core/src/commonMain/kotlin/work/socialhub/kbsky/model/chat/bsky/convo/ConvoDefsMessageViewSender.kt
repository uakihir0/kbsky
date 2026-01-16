package work.socialhub.kbsky.model.chat.bsky.convo

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoDefsMessageViewSender(
    var did: String,
)
