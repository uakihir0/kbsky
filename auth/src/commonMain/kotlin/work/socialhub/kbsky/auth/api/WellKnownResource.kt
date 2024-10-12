package work.socialhub.kbsky.auth.api

import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.auth.api.entity.wellknown.WellKnownOAuthAuthorizationServerResponse
import work.socialhub.kbsky.auth.api.entity.wellknown.WellKnownOAuthProtectedResourceResponse

interface WellKnownResource {

    /**
     * Get OAuth Protected Resource
     * https://oyster.us-east.host.bsky.network/.well-known/oauth-protected-resource
     */
    fun oAuthProtectedResource()
            : Response<WellKnownOAuthProtectedResourceResponse>


    /**
     * Get OAuth authorization server
     * https://bsky.social/.well-known/oauth-authorization-server
     */
    fun oAuthAuthorizationServer()
            : Response<WellKnownOAuthAuthorizationServerResponse>
}