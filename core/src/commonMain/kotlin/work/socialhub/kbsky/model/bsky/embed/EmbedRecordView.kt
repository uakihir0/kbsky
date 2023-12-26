package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A representation of a record embedded in another form of content
 */
@Serializable
class EmbedRecordView : EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#view"
    }

    override var type = TYPE

    var record: EmbedRecordViewUnion? = null
}
