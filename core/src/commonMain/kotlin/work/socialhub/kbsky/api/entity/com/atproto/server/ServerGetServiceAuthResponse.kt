package work.socialhub.kbsky.api.entity.com.atproto.server

import kotlinx.serialization.Serializable

@Serializable
class ServerGetServiceAuthResponse {
    lateinit var token: String
}
