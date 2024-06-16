package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ThreadgateFollowingRule : ThreadgateAllowUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate + "#followingRule"
    }

    @SerialName("\$type")
    override var type = TYPE
}
