package work.socialhub.kbsky.auth.api.entity.oauth

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.auth.OAuthProvider

class OAuthRefreshTokenRequest(
    auth: AuthProvider
) : AuthRequest(auth) {

    var clientId: String? = null
    var redirectUri: String? = null

    /**
     * Required for confidential OAuth clients.
     */
    var keyId: String? = null
    var clientAssertionType: String? = null
    var clientAssertion: String? = null

    fun buildTokenRequest(): OAuthTokenRequest {
        return OAuthTokenRequest().also {
            it.grantType = "refresh_token"

            it.clientId = clientId
            it.redirectUri = redirectUri

            // AuthProvider must be OAuthProvider in this context.
            it.refreshToken = (auth as? OAuthProvider)?.refreshTokenJwt

            it.keyId = keyId
            it.clientAssertionType = clientAssertionType
            it.clientAssertion = clientAssertion
        }
    }
}