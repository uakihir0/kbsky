package work.socialhub.kbsky.auth

import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse

class UnauthenticatedAuthProvider: AuthProvider {

    override fun beforeRequestHook(method: String, request: HttpRequest) {
        // Nothing to do
    }

    override fun afterRequestHook(method: String, request: HttpRequest, response: HttpResponse): Boolean {
        // Do nothing here
        return false
    }

    override val did: String = ""
    override val pdsDid: String = ""
    override var acceptLabelers: List<String> = emptyList()

}