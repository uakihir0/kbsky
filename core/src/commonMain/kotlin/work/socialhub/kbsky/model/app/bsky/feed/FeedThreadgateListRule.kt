package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedThreadgateListRule(
    @SerialName("\$type")
    override var type: String = TYPE,
    // at-uri
    var list: String = "",
) : FeedThreadgateAllowUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate + "#listRule"
    }


}
