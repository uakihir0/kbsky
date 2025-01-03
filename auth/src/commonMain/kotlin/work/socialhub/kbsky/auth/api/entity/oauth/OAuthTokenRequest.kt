package work.socialhub.kbsky.auth.api.entity.oauth

import work.socialhub.kbsky.api.entity.share.MapRequest

class OAuthTokenRequest : MapRequest {

    var grantType = ""
    var responseType: String? = null

    var clientId: String? = null
    var redirectUri: String? = null
    var refreshToken: String? = null

    var code: String? = null
    var codeVerifier: String? = null

    /**
     * Required for confidential OAuth clients.
     */
    var keyId: String? = null
    var clientAssertionType: String? = null
    var clientAssertion: String? = null

    override fun toMap(): Map<String, Any> =
        mutableMapOf<String, Any>().also {
            it.addParam("grant_type", grantType)
            it.addParam("response_type", responseType)
            it.addParam("client_id", clientId)
            it.addParam("redirect_uri", redirectUri)
            it.addParam("code", code)
            it.addParam("code_verifier", codeVerifier)
            it.addParam("refresh_token", refreshToken)
            it.addParam("client_assertion", clientAssertion)
            it.addParam("client_assertion_type", clientAssertionType)
        }
}
