package work.socialhub.kbsky.api.entity.com.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class RepoGetRecordResponse(
    var uri: String,
    var cid: String? = null,
    var value: RecordUnion
)
