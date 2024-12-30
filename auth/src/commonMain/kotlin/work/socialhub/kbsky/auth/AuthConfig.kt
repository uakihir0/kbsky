package work.socialhub.kbsky.auth

import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL

class AuthConfig {

    var pdsServer = BSKY_SOCIAL.uri
    var authorizationServer = BSKY_SOCIAL.uri

    var tokenEndpoint = "${BSKY_SOCIAL.uri}/oauth/token"
    var authorizationEndpoint = "${BSKY_SOCIAL.uri}/oauth/authorize"
    var pushedAuthorizationRequestEndpoint = "${BSKY_SOCIAL.uri}/oauth/par"
}