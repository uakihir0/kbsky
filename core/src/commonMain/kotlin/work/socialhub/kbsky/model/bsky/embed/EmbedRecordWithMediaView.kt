package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedRecordWithMediaView : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecordWithMedia + "#view"
    }

    @SerialName("\$type")
    override var type = TYPE

    var record: EmbedRecordView? = null

    /** only external and images  */
    var media: EmbedViewUnion? = null
}
