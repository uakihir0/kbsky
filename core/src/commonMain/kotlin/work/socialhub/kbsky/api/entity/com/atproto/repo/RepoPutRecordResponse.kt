package work.socialhub.kbsky.api.entity.com.atproto.repo

import kotlinx.serialization.Serializable

@Serializable
open data class RepoPutRecordResponse(
    var uri: String,
    var cid: String
)
