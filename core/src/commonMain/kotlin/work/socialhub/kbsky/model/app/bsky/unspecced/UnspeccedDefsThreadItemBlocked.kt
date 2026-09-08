package work.socialhub.kbsky.model.app.bsky.unspecced


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsBlockedAuthor
import kotlin.js.JsExport

@Serializable
@JsExport
data class UnspeccedDefsThreadItemBlocked(
    @SerialName("\$type")
    override var type: String = TYPE,
    var author: FeedDefsBlockedAuthor? = null,
) : UnspeccedDefsThreadItemUnion() {
    companion object {
        val TYPE = BlueskyTypes.UnspeccedDefs + "#threadItemBlocked"
    }
}
