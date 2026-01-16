package work.socialhub.kbsky.api.entity.com.atproto.repo

import kotlinx.serialization.Serializable

@Serializable
@JsExport
open class RepoPutRecordResponse {
    lateinit var uri: String
    lateinit var cid: String
}
