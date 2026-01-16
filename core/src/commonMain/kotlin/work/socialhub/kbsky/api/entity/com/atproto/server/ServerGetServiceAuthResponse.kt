package work.socialhub.kbsky.api.entity.com.atproto.server


import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
@JsExport
data class ServerGetServiceAuthResponse(
    var token: String = "",
)
