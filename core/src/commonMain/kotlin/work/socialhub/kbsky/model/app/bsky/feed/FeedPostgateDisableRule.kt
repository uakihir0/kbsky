package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class FeedPostgateDisableRule : FeedPostgateEmbeddingRulesUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedPostgate + "#disableRule"
    }

    @SerialName("\$type")
    override var type = TYPE
}
