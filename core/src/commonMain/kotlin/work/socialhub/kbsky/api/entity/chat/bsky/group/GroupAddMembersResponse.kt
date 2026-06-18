package work.socialhub.kbsky.api.entity.chat.bsky.group


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsConvoView
import kotlin.js.JsExport

@Serializable
@JsExport
data class GroupAddMembersResponse(
    var convo: ConvoDefsConvoView,
    var addedMembers: List<ActorDefsProfileViewBasic>? = null,
)
