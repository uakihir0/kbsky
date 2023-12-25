package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsThreadUnion

@Serializable
class FeedGetPostThreadResponse {
    var thread: FeedDefsThreadUnion? = null
}
