package work.socialhub.kbsky.auth

import kotlinx.serialization.Serializable

@Serializable
open class OAuthSession {

    var clientId: String? = null

    /** ECDSA P256 DER Base64 key */
    var publicKey: String? = null
    var privateKey: String? = null

    var dPoPNonce: String = ""
}