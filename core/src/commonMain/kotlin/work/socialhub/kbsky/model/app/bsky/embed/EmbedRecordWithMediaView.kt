package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedRecordWithMediaView : work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecordWithMedia + "#view"
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordWithMediaView.Companion.TYPE

    var record: work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordView? = null

    /** only external and images  */
    var media: work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion? = null
}
