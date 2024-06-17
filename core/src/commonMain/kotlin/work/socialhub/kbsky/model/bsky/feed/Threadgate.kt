package work.socialhub.kbsky.model.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class Threadgate : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var createdAt: String

    // at-uri
    lateinit var post: String

    var allow: List<ThreadgateAllowUnion>? = null
}
