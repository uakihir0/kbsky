package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsPostView

@Serializable
class FeedGetPostsResponse {
    lateinit var posts: List<FeedDefsPostView>
}
