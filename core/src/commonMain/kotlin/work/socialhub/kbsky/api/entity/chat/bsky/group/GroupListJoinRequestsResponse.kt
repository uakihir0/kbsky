package work.socialhub.kbsky.api.entity.chat.bsky.group


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.group.GroupDefsJoinRequestView
import kotlin.js.JsExport

@Serializable
@JsExport
data class GroupListJoinRequestsResponse(
    var cursor: String? = null,
    var requests: List<GroupDefsJoinRequestView>
)
