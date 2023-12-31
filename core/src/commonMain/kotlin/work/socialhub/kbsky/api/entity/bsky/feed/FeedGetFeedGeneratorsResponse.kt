package work.socialhub.kbsky.api.entity.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.feed.FeedDefsGeneratorView

@Serializable
class FeedGetFeedGeneratorsResponse {
    lateinit var feeds: List<FeedDefsGeneratorView>
}
