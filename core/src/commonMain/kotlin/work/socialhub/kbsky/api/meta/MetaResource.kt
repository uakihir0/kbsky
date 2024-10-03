package work.socialhub.kbsky.api.meta

import work.socialhub.kbsky.api.entity.meta.WellKnownOAuthAuthorizationServer
import work.socialhub.kbsky.api.entity.meta.WellKnownOAuthProtectedResourceResponse
import work.socialhub.kbsky.api.entity.share.Response

interface MetaResource {

    /**
     * Get OAuth Protected Resource
     * https://oyster.us-east.host.bsky.network/.well-known/oauth-protected-resource
     */
    fun wellKnownOAuthProtectedResource()
            : Response<WellKnownOAuthProtectedResourceResponse>


    /**
     * Get OAuth authorization server
     * https://bsky.social/.well-known/oauth-authorization-server
     */
    fun wellKnownOAuthAuthorizationServer()
            : Response<WellKnownOAuthAuthorizationServer>
}