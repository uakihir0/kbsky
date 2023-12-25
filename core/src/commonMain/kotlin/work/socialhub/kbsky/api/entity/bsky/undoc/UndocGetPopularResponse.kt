package work.socialhub.kbsky.api.entity.bsky.undoc

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsFeedViewPost

@Serializable
class UndocGetPopularResponse {
    var cursor: String? = null
    var feed: List<FeedDefsFeedViewPost>? = null
}
