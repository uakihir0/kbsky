package work.socialhub.kbsky.api.entity.com.atproto.repo

import kotlinx.serialization.Serializable

@Serializable
open data class RepoCreateRecordResponse(
    var uri: String,
    var cid: String
)
