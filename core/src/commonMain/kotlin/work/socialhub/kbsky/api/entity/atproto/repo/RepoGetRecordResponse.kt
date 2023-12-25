package work.socialhub.kbsky.api.entity.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class RepoGetRecordResponse {
    var uri: String? = null
    var cid: String? = null
    var value: RecordUnion? = null
}
