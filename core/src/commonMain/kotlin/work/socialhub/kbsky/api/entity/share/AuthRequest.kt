package work.socialhub.kbsky.api.entity.share

import work.socialhub.kbsky.internal.share._InternalUtility.fromJson
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

open class AuthRequest(
    val accessJwt: String
) {
    val bearerToken: String
        get() = "Bearer $accessJwt"

    val did: String?
        get() {
            val encodedJson = accessJwt
                .split("\\.".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()[1]

            @OptIn(ExperimentalEncodingApi::class)
            val decodedJson = Base64.decode(encodedJson)
            val map = fromJson<Map<String, String>>(decodedJson.decodeToString())
            return map["sub"]
        }
}

