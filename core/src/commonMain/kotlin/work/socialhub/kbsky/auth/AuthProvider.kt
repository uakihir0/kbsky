package work.socialhub.kbsky.auth

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse
import kotlin.js.JsExport

@JsExport
interface AuthProvider {
    @JsExport.Ignore
    fun beforeRequestHook(
        method: String,
        request: HttpRequest,
    )

    /**
     * @return If true, retry only once
     */
    @JsExport.Ignore
    fun afterRequestHook(
        method: String,
        request: HttpRequest,
        response: HttpResponse,
    ): Boolean

    val did: String
    val pdsDid: String

    // TODO: This is a temporary solution to avoid circular dependencies1
    var acceptLabelers: List<String>
}