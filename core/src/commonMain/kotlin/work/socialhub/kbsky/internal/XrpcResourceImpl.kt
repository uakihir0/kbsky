package work.socialhub.kbsky.internal

import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.api.XrpcResource
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.xrpc.XrpcQueryRequest
import work.socialhub.kbsky.internal.share.InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share.InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share.InternalUtility.proceed
import work.socialhub.kbsky.internal.share.InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class XrpcResourceImpl(
    private val config: ATProtocolConfig
) : XrpcResource {

    override suspend fun query(
        request: XrpcQueryRequest
    ): Response<JsonElement> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, request.nsid))
                .also { req ->
                    request.proxy?.let { req.header("atproto-proxy", it) }
                    request.headers?.forEach { (key, value) -> req.header(key, value) }
                }
                .accept(MediaType.JSON)
                .queries(request.params ?: mapOf())
                .getWithAuth(request.auth)
        }
    }

    override fun queryBlocking(
        request: XrpcQueryRequest
    ): Response<JsonElement> = toBlocking { query(request) }
}
