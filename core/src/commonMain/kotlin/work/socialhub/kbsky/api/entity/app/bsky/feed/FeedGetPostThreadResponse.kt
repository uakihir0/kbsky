package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadUnion

@Serializable
class FeedGetPostThreadResponse {
    lateinit var thread: work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadUnion
}
