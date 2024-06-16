package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadViewPost.Companion.TYPE

@Serializable
class FeedDefsThreadViewPost : FeedDefsThreadUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#threadViewPost"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var post: FeedDefsPostView
    var parent: FeedDefsThreadUnion? = null
    var replies: List<FeedDefsThreadUnion>? = null


}
