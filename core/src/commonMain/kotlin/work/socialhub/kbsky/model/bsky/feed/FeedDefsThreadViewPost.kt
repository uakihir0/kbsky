package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class FeedDefsThreadViewPost : FeedDefsThreadUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#threadViewPost"
    }

    override var type = TYPE

    lateinit var post: FeedDefsPostView
    var parent: FeedDefsThreadUnion? = null
    var replies: List<FeedDefsThreadUnion>? = null


}
