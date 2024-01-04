package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class FeedDefsNotFoundPost : FeedDefsThreadUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#notFoundPost"
    }

    @SerialName("\$type")
    override var type = TYPE

    var uri: String? = null
    var notFound = true
}
