package work.socialhub.kbsky.model.chat.bsky.group


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

/**
 * chat.bsky.group.defs#joinLinkViewerState
 */
@Serializable
@JsExport
data class GroupDefsJoinLinkViewerState(
    val requestedAt: String? = null,
)
