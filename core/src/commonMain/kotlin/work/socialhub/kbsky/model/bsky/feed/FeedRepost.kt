package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class FeedRepost : RecordUnion {

    companion object {
        const val TYPE = BlueskyTypes.FeedRepost
    }

    override var type = TYPE

    var subject: RepoStrongRef? = null
    var createdAt: String? = null
}
