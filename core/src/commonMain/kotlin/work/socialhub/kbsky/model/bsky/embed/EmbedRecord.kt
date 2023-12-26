package work.socialhub.kbsky.model.bsky.embed

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.atproto.repo.RepoStrongRef

@Serializable
class EmbedRecord : EmbedUnion() {

    companion object {
        const val TYPE = BlueskyTypes.EmbedRecord
    }

    override var type = TYPE

    var record: RepoStrongRef? = null
}
