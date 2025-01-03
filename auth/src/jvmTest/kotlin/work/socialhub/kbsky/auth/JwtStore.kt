package work.socialhub.kbsky.auth

import kotlinx.serialization.Serializable

@Serializable
data class JwtStore(
    var accessJwt: String? = null,
    var refreshJwt: String? = null,
)