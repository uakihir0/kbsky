package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedRecordViewNotFound : work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#viewNotFound"
    }

    @SerialName("\$type")
    override var type = work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewNotFound.Companion.TYPE

    var uri: String? = null
}
