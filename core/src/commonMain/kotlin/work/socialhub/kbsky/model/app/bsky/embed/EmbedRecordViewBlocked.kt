package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
data class EmbedRecordViewBlocked(
    @SerialName("\$type")
    override var type: String = TYPE,
    var uri: String? = null,
) : EmbedRecordViewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord + "#viewBlocked"
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null)
}
