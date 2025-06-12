package work.socialhub.kbsky.api.entity.com.atproto.server

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion

@Serializable
data class ServerCreateSessionResponse(
    var accessJwt: String = "",
    var refreshJwt: String = "",
    var handle: String = "",
    var did: String = "",

    var email: String? = null,
    var emailConfirmed: Boolean? = null,
    var emailAuthFactor: Boolean? = null,
    var didDoc: DidDocUnion? = null,
    var active: Boolean? = null,
)
