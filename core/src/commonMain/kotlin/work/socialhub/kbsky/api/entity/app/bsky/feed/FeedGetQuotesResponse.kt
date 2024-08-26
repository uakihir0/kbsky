package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView

@Serializable
class FeedGetQuotesResponse {

    lateinit var uri: String

    var cid: String? = null

    var cursor: String? = null

    lateinit var posts: List<FeedDefsPostView>
}
