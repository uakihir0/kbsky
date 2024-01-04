package work.socialhub.kbsky.internal.share

import kotlinx.datetime.TimeZone
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import work.socialhub.kbsky.ATProtocolException
import work.socialhub.kbsky.api.entity.share.ErrorResponse
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.util.DateFormatter
import work.socialhub.kbsky.util.json.AnySerializer
import work.socialhub.khttpclient.HttpResponse

/**
 * @author uakihir0
 */
object _InternalUtility {

    val json = Json {
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
            if (response.status == 200) {
                return Response(Unit, "")
            }

            throw handleError(
                exception = null,
                body = response.stringBody
            )
        } catch (e: Exception) {
            throw handleError(e)
        }
    }

    inline fun <reified T> proceed(function: () -> HttpResponse): Response<T> {
        try {
            val response: HttpResponse = function()
            if (response.status == 200) {
                return Response(
                    response.typedBody(json),
                    response.stringBody,
                )
            }

            throw handleError(
                exception = null,
                body = response.stringBody
            )
        } catch (e: Exception) {
            throw handleError(e)
        }
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
        body: String? = null,
    ): RuntimeException {

        // ATProtocolException is already handled.
        if (exception is ATProtocolException) {
            return exception
        }

        if (body != null) {
            val response = fromJson<ErrorResponse>(body)
            return ATProtocolException(
                message = response.message,
                exception = exception,
            ).also { it.response = response }
        }

        return ATProtocolException(exception)
    }
}
