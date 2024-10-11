package work.socialhub.kbsky.auth.api.entity.oauth

import work.socialhub.kbsky.api.entity.share.MapRequest

class OAuthTokenRequest : MapRequest {

    var responseType = "code"
    var grantType = "authorization_code"

    var clientId = ""
    var redirectUri = ""

    var code = ""
    var codeVerifier = ""

    var dPoPNonce: String? = null

    override fun toMap(): Map<String, Any> =
        mutableMapOf<String, Any>().also {
            it.addParam("response_type", responseType)
            it.addParam("grant_type", grantType)

            it.addParam("client_id", clientId)
            it.addParam("redirect_uri", redirectUri)

            it.addParam("code", code)
            it.addParam("code_verifier", codeVerifier)
        }
}
