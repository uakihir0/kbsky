package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.feed.FeedLike.Companion.TYPE
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class FeedLike : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedLike
    }

    @SerialName("\$type")
    override var type = TYPE

    var subject: RepoStrongRef? = null
    var createdAt: String? = null
}
