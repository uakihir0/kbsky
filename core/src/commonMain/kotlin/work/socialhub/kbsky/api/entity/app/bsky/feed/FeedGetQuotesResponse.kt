package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView

@Serializable
data class FeedGetQuotesResponse(
    var uri: String,
    var cid: String? = null,
    var cursor: String? = null,
    var posts: List<FeedDefsPostView>
)
