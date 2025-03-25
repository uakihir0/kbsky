package work.socialhub.kbsky.internal.share

import io.ktor.http.HttpMethod.Companion.Get
import io.ktor.http.HttpMethod.Companion.Post
import kotlinx.datetime.TimeZone
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import work.socialhub.kbsky.ATProtocolConfig
import work.socialhub.kbsky.ATProtocolException
import work.socialhub.kbsky.NetworkConfig
import work.socialhub.kbsky.api.entity.share.ErrorResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.util.DateFormatter
import work.socialhub.kbsky.util.json.AnySerializer
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse

/**
 * @author uakihir0
 */
object _InternalUtility {

    val json = Json {
        explicitNulls = false
        encodeDefaults = true
        ignoreUnknownKeys = true
        serializersModule = SerializersModule {
            contextual(Any::class, AnySerializer)
        }
    }

    inline fun <reified T> toJson(obj: T): String {
        return json.encodeToString(obj)
    }

    inline fun <reified T> fromJson(obj: String): T {
        return json.decodeFromString(obj)
    }

    val dateFormat = DateFormatter(
        format = "yyyy-MM-ddTHH:mm:ss.SSSZ",
        timezone = TimeZone.UTC,
    )

    fun proceedUnit(function: () -> HttpResponse): Response<Unit> {
        try {
            val response: HttpResponse = function()
            if (response.status in 200..299) {
                return Response(Unit, "")
            }

            throw handleError(
                exception = null,
                status = response.status,
                body = response.stringBody,
            )
        } catch (e: Exception) {
            throw handleError(e)
        }
    }

    inline fun <reified T> proceed(function: () -> HttpResponse): Response<T> {
        try {
            val response: HttpResponse = function()
            if (response.status in 200..299) {
                return Response(
                    response.typedBody(json),
                    response.stringBody,
                )
            }

            throw handleError(
                exception = null,
                status = response.status,
                body = response.stringBody,
            )
        } catch (e: Exception) {
            throw handleError(e)
        }
    }

    fun xrpc(config: ATProtocolConfig, path: String? = null): String {
        return xrpc(config.pdsUri, path)
    }

    fun xrpc(uri: String, path: String? = null): String {
        var url = uri
        if (!uri.endsWith("/")) {
            url += "/"
        }
        url += "xrpc/"
        if (path != null) {
            url += path
        }
        return url
    }

    fun handleError(
        exception: Exception?,
        status: Int? = null,
        body: String? = null,
    ): RuntimeException {

        // ATProtocolException is already handled.
        if (exception is ATProtocolException) {
            return exception
        }

        if (body != null) {
            val response = fromJson<ErrorResponse>(body)
            return ATProtocolException(
                message = response.messageForDisplay(),
                exception = exception,
                status = status,
                body = body,
                response = response,
            )
        }

        return ATProtocolException(exception)
    }

    suspend fun HttpRequest.getWithAuth(
        auth: AuthProvider
    ): HttpResponse {
        addContentLabelersHeader(auth.acceptLabelers)
        // TODO timeout setting

        val method = Get.value
        auth.beforeRequestHook(method, this)
        val first = this.get()
        if (!auth.afterRequestHook(method, this, first))
            return first

        auth.beforeRequestHook(method, this)
        val second = this.get()
        auth.afterRequestHook(method, this, second)
        return second
    }

    suspend fun HttpRequest.postWithAuth(
        auth: AuthProvider
    ): HttpResponse {
        addContentLabelersHeader(auth.acceptLabelers)
        // TODO timeout setting

        val method = Post.value
        auth.beforeRequestHook(method, this)
        val first = this.post()
        if (!auth.afterRequestHook(method, this, first))
            return first

        auth.beforeRequestHook(method, this)
        val second = this.post()
        auth.afterRequestHook(method, this, second)
        return second
    }

    private fun HttpRequest.addContentLabelersHeader(acceptLabelers: List<String>) {

        if (acceptLabelers.isNotEmpty()) {
            val labelers = acceptLabelers.joinToString(", ")
            this.header("atproto-accept-labelers", labelers)
        }
    }

    fun HttpRequest.setTimeouts(config: NetworkConfig) = also {

        this.requestTimeoutMillis = config.requestTimeoutMillis
        this.connectTimeoutMillis = config.connectTimeoutMillis
        this.socketTimeoutMillis = config.socketTimeoutMillis
    }
}
