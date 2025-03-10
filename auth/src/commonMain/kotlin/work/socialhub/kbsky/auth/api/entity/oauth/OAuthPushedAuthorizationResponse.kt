package work.socialhub.kbsky.auth.api.entity.oauth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OAuthPushedAuthorizationResponse(
    @SerialName("request_uri")
    val requestUri: String,

    @SerialName("expires_in")
    val expiresIn: Int = -1,
)
