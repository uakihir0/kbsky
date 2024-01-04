package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsPostView

@Serializable
class FeedSearchPostsResponse {
    var cursor: String? = null
    /** Count of search hits. Optional, may be rounded/truncated, and may not be possible to paginate through all hits. */
    var hitsTotal: Int? = null
    lateinit var posts: List<FeedDefsPostView>
}