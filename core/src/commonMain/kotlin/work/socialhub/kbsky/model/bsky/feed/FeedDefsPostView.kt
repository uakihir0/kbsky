package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.bsky.embed.EmbedViewUnion
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class FeedDefsPostView {
    var uri: String? = null
    var cid: String? = null
    var author: ActorDefsProfileViewBasic? = null
    var record: RecordUnion? = null
    var embed: EmbedViewUnion? = null
    var replyCount: Int? = null
    var repostCount: Int? = null
    var likeCount: Int? = null
    var indexedAt: String? = null
    var viewer: FeedDefsViewerState? = null
}
