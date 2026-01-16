package work.socialhub.kbsky.api.entity.app.bsky.unspecced


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost
import kotlin.js.JsExport

@Serializable
@JsExport
data class UnspeccedGetPopularResponse(
    var cursor: String? = null,
    var feed: List<FeedDefsFeedViewPost> = emptyList(),
)
