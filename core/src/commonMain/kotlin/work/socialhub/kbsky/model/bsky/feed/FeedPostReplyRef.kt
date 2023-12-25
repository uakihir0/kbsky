package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.atproto.repo.RepoStrongRef

@Serializable
class FeedPostReplyRef {
    var root: RepoStrongRef? = null
    var parent: RepoStrongRef? = null
}
