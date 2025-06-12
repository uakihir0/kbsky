package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef

@Serializable
data class EmbedRecord(
    @SerialName("\$type")
    override var type: String = TYPE,
    var record: RepoStrongRef? = null,
) : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord
    }

    @Deprecated("use primary constructor", level = DeprecationLevel.HIDDEN)
    constructor() : this(TYPE, null)
}
