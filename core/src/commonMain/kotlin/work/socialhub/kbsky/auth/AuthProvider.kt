package work.socialhub.kbsky.auth

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse

interface AuthProvider {
    fun preProcess(
        method: String,
        request: HttpRequest,
    )

    fun postProcess(
        method: String,
        request: HttpRequest,
        response: HttpResponse,
    )

    val did: String
    val pdsDid: String
}