package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsFeedViewPost

@Serializable
class FeedGetListFeedResponse {
    var cursor: String? = null
    lateinit var feed: List<FeedDefsFeedViewPost>
}
