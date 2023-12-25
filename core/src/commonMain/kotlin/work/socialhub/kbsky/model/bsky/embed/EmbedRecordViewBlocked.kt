package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class EmbedRecordViewBlocked : EmbedRecordViewUnion {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#viewBlocked"
    }

    override val type = TYPE

    var uri: String? = null
}
