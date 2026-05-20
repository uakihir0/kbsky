package work.socialhub.kbsky.api.entity.app.bsky.unspecced


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsGeneratorView
import kotlin.js.JsExport

@Serializable
@JsExport
data class UnspeccedGetPopularFeedGeneratorsResponse(
    var cursor: String? = null,
    var feeds: List<FeedDefsGeneratorView> = emptyList(),
)
