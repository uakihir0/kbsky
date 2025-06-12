package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class FeedThreadgateMentionRule(
    @SerialName("\$type")
    override var type: String = TYPE,
) : FeedThreadgateAllowUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate + "#mentionRule"
    }


}
