package work.socialhub.kbsky.auth

import kotlinx.serialization.Serializable

@Serializable
class OAuthContext {

    var clientId: String? = null
    var redirectUri: String? = null

    var state: String? = null
    var codeVerifier: String? = null

    /** ECDSA P256 DER Base64 public key */
    var publicKey: String? = null
    /** ECDSA P256 DER Base64 public key */
    var privateKey: String? = null

    var dPoPNonce: String? = null
}