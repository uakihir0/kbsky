package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
class FeedDefsReplyRef {
    var root: FeedDefsPostView? = null
    var parent: FeedDefsPostView? = null
}
