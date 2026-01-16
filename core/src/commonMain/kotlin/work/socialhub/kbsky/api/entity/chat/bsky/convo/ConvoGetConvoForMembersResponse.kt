package work.socialhub.kbsky.api.entity.chat.bsky.convo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsConvoView

@Serializable
@JsExport
data class ConvoGetConvoForMembersResponse(
    var convo: ConvoDefsConvoView
)
