package work.socialhub.kbsky.model.app.bsky.unspecced


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView
import kotlin.js.JsExport

@Serializable
@JsExport
data class UnspeccedDefsThreadItemPost(
    @SerialName("\$type")
    override var type: String = TYPE,
    var post: FeedDefsPostView? = null,
    var moreParents: Boolean = false,
    var moreReplies: Int = 0,
    /**
     * This post is part of a contiguous thread by the OP from the thread root.
     */
    var opThread: Boolean = false,
    /**
     * The 1-indexed position of this post within the contiguous OP thread.
     */
    var opThreadPostIndex: Int? = null,
    /**
     * The total number of posts in the contiguous OP thread that this post belongs to.
     */
    var opThreadPostCount: Int? = null,
    var hiddenByThreadgate: Boolean = false,
    var mutedByViewer: Boolean = false,
) : UnspeccedDefsThreadItemUnion() {
    companion object {
        val TYPE = BlueskyTypes.UnspeccedDefs + "#threadItemPost"
    }
}
