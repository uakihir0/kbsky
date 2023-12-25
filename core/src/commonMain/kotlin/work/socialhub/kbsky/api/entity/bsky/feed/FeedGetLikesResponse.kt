package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedGetLikesLike

@Serializable
class FeedGetLikesResponse {
    var uri: String? = null
    var cid: String? = null
    var cursor: String? = null
    var likes: List<FeedGetLikesLike>? = null
}
