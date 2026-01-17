package work.socialhub.kbsky.api.com.atproto


import work.socialhub.kbsky.api.entity.com.atproto.server.ServerCreateSessionRequest
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerCreateSessionResponse
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerGetServiceAuthRequest
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerGetServiceAuthResponse
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerGetSessionResponse
import work.socialhub.kbsky.api.entity.com.atproto.server.ServerRefreshSessionResponse
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import kotlin.js.JsExport

/**
 * ATProtocol/Server
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/com/atproto/server)
 */
@JsExport
interface ServerResource {

    /**
     * TODO:
     * Create an account.
     */
    fun createAccount()

    /**
     * TODO:
     * Create an invite code.
     */
    fun createInviteCode()

    /**
     * Create an authentication session.
     */
    suspend fun createSession(
        request: ServerCreateSessionRequest
    ): Response<ServerCreateSessionResponse>

    @JsExport.Ignore
    fun createSessionBlocking(
        request: ServerCreateSessionRequest
    ): Response<ServerCreateSessionResponse>

    /**
     * TODO:
     * Delete a user account with a token and password.
     */
    fun deleteAccount()

    /**
     * Delete the current session.
     */
    suspend fun deleteSession(
        request: AuthRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun deleteSessionBlocking(
        request: AuthRequest
    ): ResponseUnit

    /**
     * Get a document describing the service's accounts configuration.
     */
    fun describeServer()

    /**
     * Get a signed token on behalf of the requesting DID for the requested service.
     *
     * [Reference](https://github.com/bluesky-social/atproto/blob/main/lexicons/com/atproto/server/getServiceAuth.json)
     */
    suspend fun getServiceAuth(
        request: ServerGetServiceAuthRequest
    ): Response<ServerGetServiceAuthResponse>

    @JsExport.Ignore
    fun getServiceAuthBlocking(
        request: ServerGetServiceAuthRequest
    ): Response<ServerGetServiceAuthResponse>

    /**
     * TODO:
     * Get information about the current session.
     */
    suspend fun getSession(
        request: AuthRequest
    ): Response<ServerGetSessionResponse>

    @JsExport.Ignore
    fun getSessionBlocking(
        request: AuthRequest
    ): Response<ServerGetSessionResponse>

    /**
     * Refresh an authentication session.
     */
    suspend fun refreshSession(
        request: AuthRequest
    ): Response<ServerRefreshSessionResponse>

    @JsExport.Ignore
    fun refreshSessionBlocking(
        request: AuthRequest
    ): Response<ServerRefreshSessionResponse>

    /**
     * TODO:
     * Initiate a user account deletion via email.
     */
    fun requestAccountDelete()

    /**
     * TODO:
     * Initiate a user account password reset via email.
     */
    fun requestPasswordReset()

    /**
     * TODO:
     * Reset a user account password using a token.
     */
    fun resetPassword()
}
