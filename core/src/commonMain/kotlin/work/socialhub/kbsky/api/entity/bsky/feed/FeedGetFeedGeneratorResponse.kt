package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsGeneratorView

@Serializable
class FeedGetFeedGeneratorResponse {
    var view: FeedDefsGeneratorView? = null
    var online: Boolean? = null
    var valid: Boolean? = null
}
