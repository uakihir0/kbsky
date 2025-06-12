package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class EmbedRecordWithMedia(
    @SerialName("\$type")
    override var type: String = TYPE,
    var record: EmbedRecord? = null,
    /** only external and images  */
    var media: EmbedUnion? = null,
) : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecordWithMedia
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null, null)
}
