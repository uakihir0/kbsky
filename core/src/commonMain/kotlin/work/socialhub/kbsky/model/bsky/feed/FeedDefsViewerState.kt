package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable

@Serializable
class FeedDefsViewerState {
    var repost: String? = null
    var like: String? = null
}
