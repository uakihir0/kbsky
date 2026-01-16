package work.socialhub.kbsky.model.app.bsky.graph


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class GraphDefsListViewerState(
    var repost: String? = null,
    var like: String? = null,
    var replyDisabled: Boolean? = null,
)
