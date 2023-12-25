package work.socialhub.kbsky.internal.atproto

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolTypes.ServerCreateSession
import work.socialhub.kbsky.ATProtocolTypes.ServerDeleteSession
import work.socialhub.kbsky.ATProtocolTypes.ServerGetSession
import work.socialhub.kbsky.ATProtocolTypes.ServerRefreshSession
import work.socialhub.kbsky.api.atproto.ServerResource
import work.socialhub.kbsky.api.entity.atproto.server.ServerCreateSessionRequest
import work.socialhub.kbsky.api.entity.atproto.server.ServerCreateSessionResponse
import work.socialhub.kbsky.api.entity.atproto.server.ServerGetSessionResponse
import work.socialhub.kbsky.api.entity.atproto.server.ServerRefreshSessionResponse
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _ServerResource(
    private val uri: String
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

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(ServerCreateSession)
                    .accept(MediaType.JSON)
                    .json(request.toMappedJson())
                    .post()
            }
        }
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
                    .host(xrpc(uri))
                    .path(ServerDeleteSession)
                    .accept(MediaType.JSON)
                    .header("Authorization", request.bearerToken)
                    .post()
            }
        }
    }

    override fun describeServer() {
        throw IllegalStateException("not implemented.")
    }

    override fun getSession(
        request: AuthRequest
    ): Response<ServerGetSessionResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(ServerGetSession)
                    .accept(MediaType.JSON)
                    .header("Authorization", request.bearerToken)
                    .get()
            }
        }
    }

    override fun refreshSession(
        request: AuthRequest
    ): Response<ServerRefreshSessionResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(ServerRefreshSession)
                    .accept(MediaType.JSON)
                    .header("Authorization", request.bearerToken)
                    .get()
            }
        }
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
}
