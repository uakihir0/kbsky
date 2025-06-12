package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class EmbedRecordWithMediaView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var record: EmbedRecordView? = null,
    /** only external and images  */
    var media: EmbedViewUnion? = null,
) : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecordWithMedia + "#view"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null, null)
}
