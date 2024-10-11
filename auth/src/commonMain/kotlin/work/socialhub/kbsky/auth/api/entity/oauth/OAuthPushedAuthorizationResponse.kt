package work.socialhub.kbsky.auth.api.entity.oauth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class OAuthPushedAuthorizationResponse {
    @SerialName("request_uri")
    lateinit var requestUri: String
    @SerialName("expires_in")
    var expiresIn: Int = -1
}