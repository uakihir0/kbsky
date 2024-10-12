package work.socialhub.kbsky.auth

import kotlinx.serialization.Serializable

@Serializable
class OAuthContext {

    var clientId: String? = null

    /** ECDSA P256 DER Base64 key */
    var publicKey: String? = null
    var privateKey: String? = null

    var dPoPNonce: String? = null

    /** Following values required during OAuth */
    var redirectUri: String? = null
    var codeVerifier: String? = null
    var state: String? = null
}

