package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class ThreadgateListRule : ThreadgateAllowUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate + "#listRule"
    }

    @SerialName("\$type")
    override var type = TYPE

    // at-uri
    lateinit var list: String
}
