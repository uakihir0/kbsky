package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedGetLikesLike

@Serializable
class FeedGetLikesResponse {
    lateinit var uri: String
    var cid: String? = null
    var cursor: String? = null
    lateinit var likes: List<work.socialhub.kbsky.model.app.bsky.feed.FeedGetLikesLike>
}
