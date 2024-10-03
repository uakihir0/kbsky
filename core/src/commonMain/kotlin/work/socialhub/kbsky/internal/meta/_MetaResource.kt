package work.socialhub.kbsky.internal.meta

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.api.entity.meta.WellKnownOAuthAuthorizationServer
import work.socialhub.kbsky.api.entity.meta.WellKnownOAuthProtectedResourceResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.meta.MetaResource
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _MetaResource(
    private val config: ATProtocolConfig
) : MetaResource {

    override fun wellKnownOAuthProtectedResource()
            : Response<WellKnownOAuthProtectedResourceResponse> {
        return proceed<WellKnownOAuthProtectedResourceResponse> {
            runBlocking {
                HttpRequest()
                    .url("${config.pdsUri}.well-known/oauth-protected-resource")
                    .accept(MediaType.JSON)
                    .get()
            }
        }.also {
            if (config.updateAuthUri) {
                var authUri = it.data.authorizationServers[0]
                if (!authUri.endsWith("/")) authUri += "/"
                config.authUri = authUri
            }
        }
    }

    override fun wellKnownOAuthAuthorizationServer()
            : Response<WellKnownOAuthAuthorizationServer> {
        return proceed {
            runBlocking {
                HttpRequest()
                    .url("${config.pdsUri}.well-known/oauth-authorization-server")
                    .accept(MediaType.JSON)
                    .get()
            }
        }
    }
}