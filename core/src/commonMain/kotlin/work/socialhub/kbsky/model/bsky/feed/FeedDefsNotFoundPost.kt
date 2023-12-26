package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class FeedDefsNotFoundPost : FeedDefsThreadUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#notFoundPost"
    }

    override var type = TYPE

    var uri: String? = null
    var notFound = true
}
