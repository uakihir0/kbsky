package work.socialhub.kbsky.api.atproto

import work.socialhub.kbsky.api.entity.atproto.server.ServerCreateSessionRequest
import work.socialhub.kbsky.api.entity.atproto.server.ServerCreateSessionResponse
import work.socialhub.kbsky.api.entity.atproto.server.ServerGetSessionResponse
import work.socialhub.kbsky.api.entity.atproto.server.ServerRefreshSessionResponse
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.Response

/**
 * ATProtocol/Server
 * [Reference](https://atproto.com/lexicons/com-atproto-server)
 */
interface ServerResource {
    /**
     * Create an account.
     */
    fun createAccount()

    /**
     * Create an invite code.
     */
    fun createInviteCode()

    /**
     * Create an authentication session.
     */
    fun createSession(
        request: ServerCreateSessionRequest
    ): Response<ServerCreateSessionResponse>

    /**
     * Delete a user account with a token and password.
     */
    fun deleteAccount()

    /**
     * Delete the current session.
     */
    fun deleteSession(
        request: AuthRequest
    ): Response<Unit>

    /**
     * Get a document describing the service's accounts configuration.
     */
    fun describeServer()

    /**
     * Get information about the current session.
     */
    fun getSession(
        request: AuthRequest
    ): Response<ServerGetSessionResponse>

    /**
     * Refresh an authentication session.
     */
    fun refreshSession(
        request: AuthRequest
    ): Response<ServerRefreshSessionResponse>

    /**
     * Initiate a user account deletion via email.
     */
    fun requestAccountDelete()

    /**
     * Initiate a user account password reset via email.
     */
    fun requestPasswordReset()

    /**
     * Reset a user account password using a token.
     */
    fun resetPassword()
}
