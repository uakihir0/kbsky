package work.socialhub.kbsky.auth.internal

import work.socialhub.kbsky.auth.AuthConfig
import work.socialhub.kbsky.auth.api.OAuthResource
import work.socialhub.kbsky.auth.api.entity.oauth.OAuthPushedAuthorizationRequest

class _OAuthResource(
    private val config: AuthConfig
) : OAuthResource {

    override fun pushedAuthorizationRequest(
        request: OAuthPushedAuthorizationRequest
    ): OAuthPushedAuthorizationRequest {
        TODO("")
    }
}