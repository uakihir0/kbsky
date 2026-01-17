package work.socialhub.kbsky.model.app.bsky.feed


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

@Serializable
@JsExport
data class FeedPostgateDisableRule(
    @SerialName("\$type")
    override var type: String = TYPE,
) : FeedPostgateEmbeddingRulesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedPostgate + "#disableRule"
    }


}
