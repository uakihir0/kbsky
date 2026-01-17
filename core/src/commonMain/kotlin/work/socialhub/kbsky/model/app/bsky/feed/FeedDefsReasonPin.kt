package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedDefsReasonPin(
    @SerialName("\$type")
    override var type: String = TYPE,
) : FeedDefsReasonUnion() {

    companion object {
        val TYPE = BlueskyTypes.FeedDefs + "#reasonPin"
    }


}
