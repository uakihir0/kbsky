package work.socialhub.kbsky.auth.internal

import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.auth.AuthConfig
import work.socialhub.kbsky.auth.api.WellKnownResource
import work.socialhub.kbsky.auth.api.entity.wellknown.WellKnownOAuthAuthorizationServerResponse
import work.socialhub.kbsky.auth.api.entity.wellknown.WellKnownOAuthProtectedResourceResponse
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking
import work.socialhub.khttpclient.HttpRequest

class WellKnownResourceImpl(
    private val config: AuthConfig
) : WellKnownResource {

    override fun oAuthProtectedResource()
            : Response<WellKnownOAuthProtectedResourceResponse> {
        return toBlocking {
            proceed<WellKnownOAuthProtectedResourceResponse> {
                HttpRequest()
                    // Trim trailing slash before concatenation
                    // (e.g. prevent "https://example.com/" + "/.well-known/..." → "//.well-known/...")
                    .url("${config.pdsServer.trimEnd('/')}/.well-known/oauth-protected-resource")
                    .accept(MediaType.JSON)
                    .get()
            }.also {
                if (it.data.authorizationServers.isNotEmpty()) {
                    var authUri = it.data.authorizationServers[0]
                    if (!authUri.endsWith("/")) authUri += "/"
                    config.authorizationServer = authUri
                }
            }
        }
    }

    override fun oAuthAuthorizationServer()
            : Response<WellKnownOAuthAuthorizationServerResponse> {
        return toBlocking {
            proceed<WellKnownOAuthAuthorizationServerResponse> {
                HttpRequest()
                    // Trim trailing slash before concatenation
                    // (oAuthProtectedResource appends a trailing "/" to authorizationServer in its
                    //  response handling, so without trimEnd here a "//.well-known/..." double slash occurs)
                    .url("${config.authorizationServer.trimEnd('/')}/.well-known/oauth-authorization-server")
                    .accept(MediaType.JSON)
                    .get()
            }.also {
                config.pushedAuthorizationRequestEndpoint = it.data.pushedAuthorizationRequestEndpoint
                config.authorizationEndpoint = it.data.authorizationEndpoint
                config.tokenEndpoint = it.data.tokenEndpoint
            }
        }
    }
}