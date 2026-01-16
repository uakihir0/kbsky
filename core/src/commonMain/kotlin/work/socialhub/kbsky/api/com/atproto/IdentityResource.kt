package work.socialhub.kbsky.api.com.atproto

import work.socialhub.kbsky.api.entity.com.atproto.identity.IdentityResolveHandleRequest
import work.socialhub.kbsky.api.entity.com.atproto.identity.IdentityResolveHandleResponse
import work.socialhub.kbsky.api.entity.share.Response
import kotlin.js.JsExport

/**
 * ATProtocol/Identity
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/com/atproto/identity)
 */
@JsExport
interface IdentityResource {

    /**
     * Provides the DID of a repo.
     */
    suspend fun resolveHandle(
        request: IdentityResolveHandleRequest
    ): Response<IdentityResolveHandleResponse>

    @JsExport.Ignore
    fun resolveHandleBlocking(
        request: IdentityResolveHandleRequest
    ): Response<IdentityResolveHandleResponse>

    /**
     * Updates the handle of the account.
     */
    fun updateHandle()
}
