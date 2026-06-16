package work.socialhub.kbsky.api.entity.chat.bsky.group


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.chat.bsky.group.GroupDefsJoinLinkPreviewUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class GroupGetJoinLinkPreviewsResponse(
    var joinLinkPreviews: List<GroupDefsJoinLinkPreviewUnion>
)
