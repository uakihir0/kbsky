package work.socialhub.kbsky.model.app.bsky.feed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class FeedThreadgate : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.FeedThreadgate
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var createdAt: String

    // at-uri
    lateinit var post: String

    var allow: List<FeedThreadgateAllowUnion>? = null
}
