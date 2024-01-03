package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedGetLikesLike

@Serializable
class FeedGetLikesResponse {
    lateinit var uri: String
    var cid: String? = null
    var cursor: String? = null
    lateinit var likes: List<FeedGetLikesLike>
}
