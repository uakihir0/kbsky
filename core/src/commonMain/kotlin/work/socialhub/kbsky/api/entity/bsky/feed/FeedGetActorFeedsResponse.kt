package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsGeneratorView

@Serializable
class FeedGetActorFeedsResponse {
    var cursor: String? = null
    lateinit var feeds: List<FeedDefsGeneratorView>
}
