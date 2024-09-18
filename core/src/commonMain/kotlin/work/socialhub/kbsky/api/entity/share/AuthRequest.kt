package work.socialhub.kbsky.api.entity.share

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

open class AuthRequest(
    val accessJwt: String
) {
    val bearerToken: String
        get() = "Bearer $accessJwt"

    val did: String
        get() {
            return jwt.sub
        }

    val jwt: Jwt
        get() {
            val encodedJson = accessJwt
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
}

