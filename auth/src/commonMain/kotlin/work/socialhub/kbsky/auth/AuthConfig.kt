package work.socialhub.kbsky.auth

import work.socialhub.kbsky.domain.Service

class AuthConfig {

    var pdsServer: String = Service.BSKY_SOCIAL.uri

    var authorizationServer: String = ""

    var pushedAuthorizationRequestEndpoint: String = ""
}