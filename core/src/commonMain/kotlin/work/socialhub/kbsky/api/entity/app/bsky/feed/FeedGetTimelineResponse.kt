package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
data class FeedGetTimelineResponse(
    var cursor: String? = null,
    var feed: List<work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost>
)
