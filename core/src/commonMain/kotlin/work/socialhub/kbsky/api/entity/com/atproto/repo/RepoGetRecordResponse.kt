package work.socialhub.kbsky.api.entity.com.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class RepoGetRecordResponse {
    lateinit var uri: String
    var cid: String? = null
    lateinit var value: RecordUnion
}
