package work.socialhub.kbsky.auth.api.entity.oauth

import work.socialhub.kbsky.api.entity.share.MapRequest

class OAuthTokenRequest : MapRequest {

    var grantType = "authorization_code"
    var responseType = ""

    var clientId = ""
    var redirectUri = ""
    var refreshToken = ""

    /**
     * Must be a signed JWT for confidential clients
     */
    var client_assertion = ""

    var code = ""
    var codeVerifier = ""

    var dPoPNonce: String? = null

    override fun toMap(): Map<String, Any> =
        mutableMapOf<String, Any>().also {
            //Compulsory field
            it.addParam("grant_type", grantType)

            if (responseType.isNotBlank()) {
                it.addParam("response_type", responseType)
            }
            if (clientId.isNotBlank()) {
                it.addParam("client_id", clientId)
            }
            if (redirectUri.isNotBlank()) {
                it.addParam("redirect_uri", redirectUri)
            }
            if (code.isNotBlank()) {
                it.addParam("code", code)
            }
            if (codeVerifier.isNotBlank()) {
                it.addParam("code_verifier", codeVerifier)
            }
            if (refreshToken.isNotBlank()) {
                it.addParam("refresh_token", refreshToken)
            }
            if (client_assertion.isNotBlank()) {
                it.addParam("client_assertion", refreshToken)
            }
        }
}
