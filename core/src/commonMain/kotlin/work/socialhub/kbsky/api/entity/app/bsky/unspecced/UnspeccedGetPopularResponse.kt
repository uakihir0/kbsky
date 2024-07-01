package work.socialhub.kbsky.api.entity.app.bsky.unspecced

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost

@Serializable
class UnspeccedGetPopularResponse {
    var cursor: String? = null
    lateinit var feed: List<FeedDefsFeedViewPost>
}
