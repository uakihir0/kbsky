package work.socialhub.kbsky.model.com.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class RepoListRecordsRecord(
    var uri: String? = null,
    var cid: String? = null,
    var value: RecordUnion? = null
)
