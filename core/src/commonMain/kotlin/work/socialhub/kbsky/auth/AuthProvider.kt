package work.socialhub.kbsky.auth

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse

interface AuthProvider {
    fun beforeRequestHook(
        method: String,
        request: HttpRequest,
    )

    fun afterRequestHook(
        method: String,
        request: HttpRequest,
        response: HttpResponse,
    )

    val did: String
    val pdsDid: String
}