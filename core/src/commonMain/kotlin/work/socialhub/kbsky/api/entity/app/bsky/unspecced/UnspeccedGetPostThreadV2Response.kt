package work.socialhub.kbsky.api.entity.app.bsky.unspecced


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadgateView
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItem
import kotlin.js.JsExport

/**
 * Response for a post thread (v2) request.
 */
@Serializable
@JsExport
data class UnspeccedGetPostThreadV2Response(
    var thread: List<UnspeccedDefsThreadItem> = emptyList(),
    var threadgate: FeedDefsThreadgateView? = null,
    var hasOtherReplies: Boolean = false,
)
