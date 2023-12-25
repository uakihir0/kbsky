package work.socialhub.kbsky.internal.atproto

import kotlinx.coroutines.runBlocking
import work.socialhub.kbsky.ATProtocolTypes.IdentifyResolveHandle
import work.socialhub.kbsky.api.atproto.IdentityResource
import work.socialhub.kbsky.api.entity.atproto.identity.IdentityResolveHandleRequest
import work.socialhub.kbsky.api.entity.atproto.identity.IdentityResolveHandleResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.khttpclient.HttpRequest

class _IdentityResource(
    private val uri: String
) : IdentityResource {

    override fun resolveHandle(
        request: IdentityResolveHandleRequest
    ): Response<IdentityResolveHandleResponse> {

        return proceed {
            runBlocking {
                HttpRequest()
                    .host(xrpc(uri))
                    .path(IdentifyResolveHandle)
                    .accept(MediaType.JSON)
                    .queries(request.toMap())
                    .get()
            }
        }
    }

    // TODO: implement
    override fun updateHandle() {
        throw IllegalStateException("not implemented.")
    }
}
