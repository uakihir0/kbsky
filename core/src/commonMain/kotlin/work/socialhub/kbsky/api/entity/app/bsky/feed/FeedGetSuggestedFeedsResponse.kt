package work.socialhub.kbsky.api.entity.app.bsky.feed


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsGeneratorView
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedGetSuggestedFeedsResponse(
    var cursor: String? = null,
    var feeds: List<FeedDefsGeneratorView> = emptyList(),
)
