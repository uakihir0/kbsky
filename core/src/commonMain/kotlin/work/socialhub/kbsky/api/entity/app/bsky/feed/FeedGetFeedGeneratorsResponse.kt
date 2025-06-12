package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsGeneratorView

@Serializable
data class FeedGetFeedGeneratorsResponse(
    var feeds: List<FeedDefsGeneratorView> = emptyList(),
)
