package work.socialhub.kbsky.internal.com.atproto

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.ATProtocolTypes.ServerCreateSession
import work.socialhub.kbsky.ATProtocolTypes.ServerDeleteSession
import work.socialhub.kbsky.ATProtocolTypes.ServerGetServiceAuth
import work.socialhub.kbsky.ATProtocolTypes.ServerGetSession
import work.socialhub.kbsky.ATProtocolTypes.ServerRefreshSession
import work.socialhub.kbsky.api.com.atproto.ServerResource
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerCreateSessionRequest
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerCreateSessionResponse
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerGetServiceAuthRequest
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerGetServiceAuthResponse
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerGetSessionResponse
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerRefreshSessionResponse
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _ServerResource(
    private val config: ATProtocolConfig
) : ServerResource {

    override fun createAccount() {
        throw IllegalStateException("not implemented.")
    }

    override fun createInviteCode() {
        throw IllegalStateException("not implemented.")
    }

    override fun createSession(
        request: ServerCreateSessionRequest
    ): Response<ServerCreateSessionResponse> {
        return proceed<ServerCreateSessionResponse> {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, ServerCreateSession))
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .post()
            }
        }.also { updatePdsUri(it.data.didDoc) }
    }

    override fun deleteAccount() {
        throw IllegalStateException("not implemented.")
    }

    override fun deleteSession(
        request: AuthRequest
    ): Response<Unit> {

        return proceedUnit {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, ServerDeleteSession))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .post()
            }
        }
    }

    override fun describeServer() {
        throw IllegalStateException("not implemented.")
    }

    override fun getServiceAuth(
        request: ServerGetServiceAuthRequest
    ): Response<ServerGetServiceAuthResponse> {
        return proceed<ServerGetServiceAuthResponse> {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, ServerGetServiceAuth))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    override fun getSession(
        request: AuthRequest
    ): Response<ServerGetSessionResponse> {
        return proceed<ServerGetSessionResponse> {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, ServerGetSession))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .get()
            }
        }.also { updatePdsUri(it.data.didDoc) }
    }

    override fun refreshSession(
        request: AuthRequest
    ): Response<ServerRefreshSessionResponse> {
        return proceed<ServerRefreshSessionResponse> {
            runBlocking {
                HttpRequest()
                    .url(xrpc(config, ServerRefreshSession))
                    .header("Authorization", request.bearerToken)
                    .accept(MediaType.JSON)
                    .post()
            }
        }.also { updatePdsUri(it.data.didDoc) }
    }

    override fun requestAccountDelete() {
        throw IllegalStateException("not implemented.")
    }

    override fun requestPasswordReset() {
        throw IllegalStateException("not implemented.")
    }

    override fun resetPassword() {
        throw IllegalStateException("not implemented.")
    }

    private fun updatePdsUri(doc: DidDocUnion?){
        if (config.updatePdsUri) {
            doc?.asDIDDetails?.also { d ->
                d.pdsEndpoint()?.also {
                    config.pdsUri = it
                }
            }
        }
    }
}
