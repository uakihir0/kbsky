package work.socialhub.kbsky.api.entity.chat.bsky.convo


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic
import kotlin.js.JsExport

@Serializable
@JsExport
data class ConvoGetConvoMembersResponse(
    var cursor: String? = null,
    var members: List<ActorDefsProfileViewBasic>
)
