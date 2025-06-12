package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
data class FeedDefsFeedViewPost(
    var post: FeedDefsPostView = FeedDefsPostView(),
    var reply: FeedDefsReplyRef? = null,
    var reason: FeedDefsReasonUnion? = null,
)
