package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A representation of a record embedded in another form of content
 */
@Serializable
data class EmbedRecordView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var record: EmbedRecordViewUnion? = null,
) : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#view"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null)
}
