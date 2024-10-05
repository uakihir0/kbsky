package work.socialhub.kbsky.auth.api

import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationRequest

interface OAuthResource {

    fun pushedAuthorizationRequest(
        request: OAuthPushedAuthorizationRequest
    ): OAuthPushedAuthorizationRequest
}