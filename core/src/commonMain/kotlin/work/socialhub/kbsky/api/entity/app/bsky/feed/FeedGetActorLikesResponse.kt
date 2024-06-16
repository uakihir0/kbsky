package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost

@Serializable
class FeedGetActorLikesResponse {
    var cursor: String? = null
    lateinit var feed: List<FeedDefsFeedViewPost>
}