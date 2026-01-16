package work.socialhub.kbsky.api.entity.com.atproto.repo

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.repo.RepoListRecordsRecord

@Serializable
@JsExport
data class RepoListRecordsResponse(
    var cursor: String? = null,
    var records: List<RepoListRecordsRecord> = emptyList(),
)
