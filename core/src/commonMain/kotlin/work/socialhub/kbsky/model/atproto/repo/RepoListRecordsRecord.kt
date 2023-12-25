package work.socialhub.kbsky.model.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class RepoListRecordsRecord {
    var uri: String? = null
    var cid: String? = null
    var value: RecordUnion? = null
}
