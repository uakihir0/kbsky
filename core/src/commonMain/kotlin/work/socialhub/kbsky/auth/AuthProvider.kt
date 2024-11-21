package work.socialhub.kbsky.auth

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse

interface AuthProvider {
    fun beforeRequestHook(
        method: String,
        request: HttpRequest,
    )

    /**
     * @return If true, retry only once
     */
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