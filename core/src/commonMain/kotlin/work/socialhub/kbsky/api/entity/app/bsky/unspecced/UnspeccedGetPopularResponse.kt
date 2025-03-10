package work.socialhub.kbsky.api.entity.app.bsky.unspecced

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost

@Serializable
data class UnspeccedGetPopularResponse(
    var cursor: String? = null,
    var feed: List<FeedDefsFeedViewPost>
)
