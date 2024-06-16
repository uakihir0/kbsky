package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A representation of a record embedded in another form of content
 */
@Serializable
class EmbedRecordView : work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#view"
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordView.Companion.TYPE

    var record: work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewUnion? = null
}
