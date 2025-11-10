package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef

@Serializable
data class FeedDefsBookmarkView(
    val subject: RepoStrongRef,
    val createdAt: String? = null,
    val item: FeedDefsBookmarkItemUnion,
)
