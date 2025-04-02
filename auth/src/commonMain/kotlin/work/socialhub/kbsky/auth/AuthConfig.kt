package work.socialhub.kbsky.auth

import work.socialhub.kbsky.NetworkConfig
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL

class AuthConfig : NetworkConfig() {

    var pdsServer = BSKY_SOCIAL.uri
    var authorizationServer = BSKY_SOCIAL.uri

    var tokenEndpoint = "${BSKY_SOCIAL.uri}/oauth/token"
    var authorizationEndpoint = "${BSKY_SOCIAL.uri}/oauth/authorize"
    var pushedAuthorizationRequestEndpoint = "${BSKY_SOCIAL.uri}/oauth/par"

    // Confidential client parameters, if set PAR & token requests will be signed by this key
    // Note that the keyId must exists in the jwks section of client-metadata.json and the published
    // public key must match this private key.
    var confidentialClientKeyId: String? = null
    var confidentialClientPrivateKey: String? = null
}