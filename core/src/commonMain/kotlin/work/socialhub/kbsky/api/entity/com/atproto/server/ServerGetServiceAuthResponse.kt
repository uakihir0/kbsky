package work.socialhub.kbsky.api.entity.com.atproto.server

import kotlinx.serialization.Serializable

@Serializable
@JsExport
data class ServerGetServiceAuthResponse(
    var token: String = "",
)
