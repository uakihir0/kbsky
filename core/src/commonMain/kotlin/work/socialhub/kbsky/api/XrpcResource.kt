package work.socialhub.kbsky.api


import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.xrpc.XrpcQueryRequest
import kotlin.js.JsExport

/**
 * Generic XRPC calls.
 * Use this for endpoints (e.g. third-party lexicons) which have no dedicated API in this library.
 */
@JsExport
interface XrpcResource {

    /**
     * Call an arbitrary XRPC query (GET) with auth, and return the response body as a JsonElement.
     */
    suspend fun query(
        request: XrpcQueryRequest
    ): Response<JsonElement>

    @JsExport.Ignore
    fun queryBlocking(
        request: XrpcQueryRequest
    ): Response<JsonElement>
}
