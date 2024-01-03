package work.socialhub.kbsky.api.entity.atproto.repo

import kotlinx.serialization.Serializable

@Serializable
open class RepoCreateRecordResponse {
    lateinit var uri: String
    lateinit var cid: String
}
