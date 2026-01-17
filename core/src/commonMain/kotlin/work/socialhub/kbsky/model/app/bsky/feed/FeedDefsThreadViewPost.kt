package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsThreadViewPost(
    @SerialName("\$type")
    override var type: String = TYPE,
    var post: FeedDefsPostView? = null,
    var parent: FeedDefsThreadUnion? = null,
    var replies: List<FeedDefsThreadUnion>? = null,
) : FeedDefsThreadUnion() {
    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#threadViewPost"
    }
}
