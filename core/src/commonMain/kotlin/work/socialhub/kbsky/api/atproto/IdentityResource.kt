package work.socialhub.kbsky.api.atproto

import work.socialhub.kbsky.api.entity.atproto.identity.IdentityResolveHandleRequest
import work.socialhub.kbsky.api.entity.atproto.identity.IdentityResolveHandleResponse
import work.socialhub.kbsky.api.entity.share.Response

/**
 * ATProtocol/Identity
 * [Reference](https://github.com/bluesky-social/atproto/tree/main/lexicons/com/atproto/identity)
 */
interface IdentityResource {

    /**
     * Provides the DID of a repo.
     */
    fun resolveHandle(
        request: IdentityResolveHandleRequest
    ): Response<IdentityResolveHandleResponse>

    /**
     * Updates the handle of the account.
     */
    fun updateHandle()
}
