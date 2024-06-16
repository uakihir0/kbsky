package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
class FeedDefsViewerState {
    var repost: String? = null
    var like: String? = null
    var replyDisabled: Boolean? = null
}
