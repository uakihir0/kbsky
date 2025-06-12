package work.socialhub.kbsky.api.entity.com.atproto.server

import kotlinx.serialization.Serializable

@Serializable
data class ServerGetServiceAuthResponse(
    var token: String = "",
)
