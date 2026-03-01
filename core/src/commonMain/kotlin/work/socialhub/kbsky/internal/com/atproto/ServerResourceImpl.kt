package work.socialhub.kbsky.internal.com.atproto

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
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import work.socialhub.kbsky.internal.share.InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share.InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.internal.share.InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share.InternalUtility.xrpc
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class ServerResourceImpl(
    private val config: ATProtocolConfig
) : ServerResource {

    override fun createAccount() {
        throw IllegalStateException("not implemented.")
    }

    override fun createInviteCode() {
        throw IllegalStateException("not implemented.")
    }

    override suspend fun createSession(
        request: ServerCreateSessionRequest
    ): Response<ServerCreateSessionResponse> {
        return proceed<ServerCreateSessionResponse> {
            httpRequest(config)
                .url(xrpc(config, ServerCreateSession))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .post()
        }.also { updatePdsUri(it.data.didDoc) }
    }

    override fun createSessionBlocking(
        request: ServerCreateSessionRequest
    ): Response<ServerCreateSessionResponse> = toBlocking { createSession(request) }

    override fun deleteAccount() {
        throw IllegalStateException("not implemented.")
    }

    override suspend fun deleteSession(
        request: AuthRequest
    ): ResponseUnit {

        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, ServerDeleteSession))
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }
    }

    override fun deleteSessionBlocking(
        request: AuthRequest
    ): ResponseUnit = toBlocking { deleteSession(request) }

    override fun describeServer() {
        throw IllegalStateException("not implemented.")
    }

    override suspend fun getServiceAuth(
        request: ServerGetServiceAuthRequest
    ): Response<ServerGetServiceAuthResponse> {
        return proceed<ServerGetServiceAuthResponse> {
            httpRequest(config)
                .url(xrpc(config, ServerGetServiceAuth))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun getServiceAuthBlocking(
        request: ServerGetServiceAuthRequest
    ): Response<ServerGetServiceAuthResponse> = toBlocking { getServiceAuth(request) }

    override suspend fun getSession(
        request: AuthRequest
    ): Response<ServerGetSessionResponse> {
        return proceed<ServerGetSessionResponse> {
            httpRequest(config)
                .url(xrpc(config, ServerGetSession))
                .accept(MediaType.JSON)
                .getWithAuth(request.auth)
        }.also { updatePdsUri(it.data.didDoc) }
    }

    override fun getSessionBlocking(
        request: AuthRequest
    ): Response<ServerGetSessionResponse> = toBlocking { getSession(request) }

    override suspend fun refreshSession(
        request: AuthRequest
    ): Response<ServerRefreshSessionResponse> {
        return proceed<ServerRefreshSessionResponse> {
            httpRequest(config)
                .url(xrpc(config, ServerRefreshSession))
                .accept(MediaType.JSON)
                .postWithAuth(request.auth)
        }.also { updatePdsUri(it.data.didDoc) }
    }

    override fun refreshSessionBlocking(
        request: AuthRequest
    ): Response<ServerRefreshSessionResponse> = toBlocking { refreshSession(request) }

    override fun requestAccountDelete() {
        throw IllegalStateException("not implemented.")
    }

    override fun requestPasswordReset() {
        throw IllegalStateException("not implemented.")
    }

    override fun resetPassword() {
        throw IllegalStateException("not implemented.")
    }

    private fun updatePdsUri(doc: DidDocUnion?) {
        if (config.updatePdsUri) {
            doc?.asDIDDetails?.also { d ->
                d.pdsEndpoint()?.also {
                    config.pdsUri = it
                }
            }
        }
    }
}
