package work.socialhub.kbsky.internal.com.atproto

import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.ATProtocolTypes.IdentifyResolveHandle
import work.socialhub.kbsky.api.com.atproto.IdentityResource
import work.socialhub.kbsky.api.entity.com.atproto.identity.IdentityResolveHandleRequest
import work.socialhub.kbsky.api.entity.com.atproto.identity.IdentityResolveHandleResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share.InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.internal.share.InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class IdentityResourceImpl(
    private val config: ATProtocolConfig
) : IdentityResource {

    override suspend fun resolveHandle(
        request: IdentityResolveHandleRequest
    ): Response<IdentityResolveHandleResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, IdentifyResolveHandle))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .get()
        }
    }

    override fun resolveHandleBlocking(
        request: IdentityResolveHandleRequest
    ): Response<IdentityResolveHandleResponse> = toBlocking { resolveHandle(request) }

    // TODO: implement
    override fun updateHandle() {
        throw IllegalStateException("not implemented.")
    }
}
