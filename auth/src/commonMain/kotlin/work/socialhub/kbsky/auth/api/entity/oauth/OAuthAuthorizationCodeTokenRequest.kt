package work.socialhub.kbsky.auth.api.entity.oauth

class OAuthAuthorizationCodeTokenRequest {

    var clientId: String? = null
    var redirectUri: String? = null

    /**
     * Required for confidential OAuth clients.
     */
    var keyId: String? = null
    var clientAssertionType: String? = null
    var clientAssertion: String? = null

    var code: String? = null
    var codeVerifier: String? = null

    fun buildTokenRequest(): OAuthTokenRequest {
        return OAuthTokenRequest().also {
            it.grantType = "authorization_code"

            it.clientId = clientId
            it.redirectUri = redirectUri

            it.keyId = keyId
            it.clientAssertionType = clientAssertionType
            it.clientAssertion = clientAssertion

            it.code = code
            it.codeVerifier = codeVerifier
        }
    }
}