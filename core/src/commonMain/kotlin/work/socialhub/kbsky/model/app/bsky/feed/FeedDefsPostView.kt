package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsLabel
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsPostView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var uri: String? = null,
    var cid: String? = null,
    var author: ActorDefsProfileViewBasic? = null,
    var record: RecordUnion? = null,
    var embed: EmbedViewUnion? = null,
    var replyCount: Int? = null,
    var repostCount: Int? = null,
    var likeCount: Int? = null,
    var bookmarkCount: Int? = null,
    var quoteCount: Int? = null,
    /**
     * Approximate number of times the post has been viewed.
     * Only included in authenticated responses to the post's author
     * when eligible to see the count. Counts less than 100 are omitted.
     */
    var viewCount: Int? = null,
    var indexedAt: String? = null,
    var viewer: FeedDefsViewerState? = null,
    var labels: List<LabelDefsLabel>? = null,
    var threadgate: FeedDefsThreadgateView? = null,
) : FeedDefsBookmarkItemUnion {
    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#postView"
    }
}
