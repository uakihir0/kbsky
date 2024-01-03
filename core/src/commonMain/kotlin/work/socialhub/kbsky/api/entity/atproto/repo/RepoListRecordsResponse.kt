package work.socialhub.kbsky.api.entity.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.atproto.repo.RepoListRecordsRecord

@Serializable
class RepoListRecordsResponse {
    var cursor: String? = null
    lateinit var records: List<RepoListRecordsRecord>
}
