package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView

@Serializable
data class FeedSearchPostsResponse(
    var cursor: String? = null,
    /** Count of search hits. Optional, may be rounded/truncated, and may not be possible to paginate through all hits. */
    var hitsTotal: Int? = null,
    var posts: List<FeedDefsPostView>
)