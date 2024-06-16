package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class Threadgate {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate
    }

    @SerialName("\$type")
    var type = TYPE

    lateinit var createdAt: String

    // at-uri
    lateinit var post: String

    var allow: List<ThreadgateAllowUnion>? = null
}
