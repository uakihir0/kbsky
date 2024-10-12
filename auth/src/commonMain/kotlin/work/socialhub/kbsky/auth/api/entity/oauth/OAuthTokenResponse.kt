package work.socialhub.kbsky.auth.api.entity.oauth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class OAuthTokenResponse {

    @SerialName("access_token")
    lateinit var accessToken: String

    @SerialName("token_type")
    lateinit var tokenType: String

    @SerialName("refresh_token")
    lateinit var refreshToken: String

    @SerialName("scope")
    lateinit var scope: String

    @SerialName("expires_in")
    var expiresIn: Int = -1

    @SerialName("sub")
    lateinit var sub: String
}