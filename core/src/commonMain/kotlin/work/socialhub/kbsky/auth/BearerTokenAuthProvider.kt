package work.socialhub.kbsky.auth

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import work.socialhub.khttpclient.HttpRequest
import work.socialhub.khttpclient.HttpResponse
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class BearerTokenAuthProvider(
    val accessTokenJwt: String,
    val refreshTokenJwt: String? = null,
) : AuthProvider {

    override fun beforeRequestHook(
        method: String,
        request: HttpRequest
    ) {
        request.header("Authorization", bearerToken)
    }

    override fun afterRequestHook(
        method: String,
        request: HttpRequest,
        response: HttpResponse
    ): Boolean {
        return false
    }

    override val did: String
        get() = jwt.sub

    override val pdsDid: String
        get() = jwt.aud

    val bearerToken: String
        get() = "Bearer $accessTokenJwt"

    val jwt: Jwt
        get() {
            val encodedJson = accessTokenJwt
                .split("\\.".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()[1]

            @OptIn(ExperimentalEncodingApi::class)
            val decodedJson = Base64.Default.withPadding(Base64.PaddingOption.PRESENT_OPTIONAL).decode(encodedJson)
            return fromJson<Jwt>(decodedJson.decodeToString())
        }

    @Serializable
    class Jwt {
        lateinit var scope: String
        lateinit var sub: String
        lateinit var aud: String
        var iat: Int = -1
        var exp: Int = -1
    }

    override var acceptLabelers: List<String> = emptyList()
}