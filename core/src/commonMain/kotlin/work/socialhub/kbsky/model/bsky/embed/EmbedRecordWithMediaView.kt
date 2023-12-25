package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedRecordWithMediaView : EmbedViewUnion {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecordWithMedia + "#view"
    }

    override val type = TYPE

    var record: EmbedRecordView? = null

    /** only external and images  */
    var media: EmbedViewUnion? = null
}
