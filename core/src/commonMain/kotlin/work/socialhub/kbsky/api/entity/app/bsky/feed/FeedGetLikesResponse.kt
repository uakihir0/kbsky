package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedGetLikesLike

@Serializable
data class FeedGetLikesResponse(
    var uri: String,
    var cid: String? = null,
    var cursor: String? = null,
    var likes: List<FeedGetLikesLike>
)
