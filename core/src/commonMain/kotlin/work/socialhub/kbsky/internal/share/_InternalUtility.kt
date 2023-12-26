package work.socialhub.kbsky.internal.share

import kotlinx.datetime.TimeZone
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import work.socialhub.kbsky.ATProtocolException
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
        format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        timezone = TimeZone.UTC,
    )

    fun proceedUnit(function: () -> HttpResponse): Response<Unit> {
        try {
            val response: HttpResponse = function()
            if (response.status == 200) {
                return Response(Unit, "")
            }
            // TODO: include error response in exception
            throw ATProtocolException(response.stringBody())
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
                    response.stringBody(),
                )
            }
            // TODO: include error response in exception
            throw ATProtocolException(response.stringBody())
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

    fun handleError(e: Exception): RuntimeException {
        /*
        return try {
            val message: String = e.getResponse().asString()
            val error: Map<String, Any> = gson.fromJson(
                message,
                object : TypeToken<Map<String?, Any?>?>() {}.getType()
            )
            val exception = ATProtocolException(e)
            exception.setErrorMessage(error["message"].toString())
            exception.setError(error["error"].toString())
            exception
        } catch (t: java.lang.Exception) {
            ATProtocolException(e)
        }
        */
        return ATProtocolException(e)
    }
}
