package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedRecordWithMedia : work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecordWithMedia
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordWithMedia.Companion.TYPE

    var record: work.socialhub.kbsky.model.app.bsky.embed.EmbedRecord? = null

    /** only external and images  */
    var media: work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion? = null
}
