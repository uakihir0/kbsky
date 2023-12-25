package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsFeedViewPost

@Serializable
class FeedGetAuthorFeedResponse {
    var cursor: String? = null
    var feed: List<FeedDefsFeedViewPost>? = null
}
