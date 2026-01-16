package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsReplyRef(
    var root: FeedDefsPostView? = null,
    var parent: FeedDefsPostView? = null,
)
