package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class FeedDefsNotFoundPost(
    @SerialName("\$type")
    override var type: String = TYPE,
    var uri: String? = null,
    var notFound: Boolean = true,
) : FeedDefsThreadUnion(), FeedDefsBookmarkItemUnion {
    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#notFoundPost"
    }
}
