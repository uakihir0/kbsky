package work.socialhub.kbsky.api.entity.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsBookmarkView

@Serializable
data class FeedGetBookmarksResponse(
    val cursor: String? = null,
    val bookmarks: List<FeedDefsBookmarkView>,
)