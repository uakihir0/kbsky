package work.socialhub.kbsky.api.entity.atproto.repo

import kotlinx.serialization.Serializable

@Serializable
open class RepoPutRecordResponse {
    lateinit var uri: String
    lateinit var cid: String
}
