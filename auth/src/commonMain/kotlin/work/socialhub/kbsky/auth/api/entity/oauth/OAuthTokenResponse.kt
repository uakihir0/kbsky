package work.socialhub.kbsky.auth.api.entity.oauth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OAuthTokenResponse(

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("token_type")
    val tokenType: String,

    @SerialName("refresh_token")
    val refreshToken: String,

    @SerialName("scope")
    val scope: String,

    @SerialName("expires_in")
    val expiresIn: Int = -1,

    @SerialName("sub")
    val sub: String,
)