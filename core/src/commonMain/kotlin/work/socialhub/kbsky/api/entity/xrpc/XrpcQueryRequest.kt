package work.socialhub.kbsky.api.entity.xrpc


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

/**
 * Request for an arbitrary XRPC query (GET /xrpc/{nsid}).
 */
@JsExport
data class XrpcQueryRequest(
    override val auth: AuthProvider,
    /** The NSID of the query. (e.g. "com.example.getSomething") */
    var nsid: String,
    /** Query parameters. */
    var params: Map<String, Any>? = null,
    /**
     * The service to proxy the request to via the PDS. (e.g. "did:web:api.example.com#example_appview")
     * Sent as the `atproto-proxy` header.
     */
    var proxy: String? = null,
    /** Additional request headers. */
    var headers: Map<String, String>? = null,
) : AuthRequest(auth)
