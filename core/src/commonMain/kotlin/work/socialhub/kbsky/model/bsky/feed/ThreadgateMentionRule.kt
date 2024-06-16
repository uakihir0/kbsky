package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ThreadgateMentionRule : ThreadgateAllowUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate + "#mentionRule"
    }

    @SerialName("\$type")
    override var type = TYPE
}
