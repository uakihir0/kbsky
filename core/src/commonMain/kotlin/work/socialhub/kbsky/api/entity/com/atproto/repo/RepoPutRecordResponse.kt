package work.socialhub.kbsky.api.entity.com.atproto.repo


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
open class RepoPutRecordResponse {
    lateinit var uri: String
    lateinit var cid: String
}
