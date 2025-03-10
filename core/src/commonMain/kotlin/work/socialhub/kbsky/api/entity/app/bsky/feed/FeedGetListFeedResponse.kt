package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost

@Serializable
data class FeedGetListFeedResponse(
    var cursor: String? = null,
    var feed: List<FeedDefsFeedViewPost>
)
