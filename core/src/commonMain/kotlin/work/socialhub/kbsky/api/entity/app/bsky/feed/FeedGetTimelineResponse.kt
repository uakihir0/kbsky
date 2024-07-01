package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
class FeedGetTimelineResponse {
    var cursor: String? = null
    lateinit var feed: List<work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost>
}
