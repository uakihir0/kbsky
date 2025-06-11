package work.socialhub.kbsky.stream.entity.app.bsky.model

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class Commit(
    var rev: String = "",
    var operation: String = "",
    var collection: String = "",
    var rkey: String = "",
    var record: RecordUnion? = null,
    var cid: String? = null,
)
