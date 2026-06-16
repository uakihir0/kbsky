package work.socialhub.kbsky.model.chat.bsky.group


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * chat.bsky.group.defs#joinLinkView
 */
@Serializable
@JsExport
data class GroupDefsJoinLinkView(
    val code: String,
    // chat.bsky.group.defs#linkEnabledStatus ("enabled" / "disabled")
    val enabledStatus: String,
    val requireApproval: Boolean,
    // chat.bsky.group.defs#joinRule ("anyone" / "followedByOwner")
    val joinRule: String,
    val createdAt: String,
)
