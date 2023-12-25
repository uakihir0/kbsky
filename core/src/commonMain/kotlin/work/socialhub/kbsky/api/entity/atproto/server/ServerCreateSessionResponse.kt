package work.socialhub.kbsky.api.entity.atproto.server

import kotlinx.serialization.Serializable

@Serializable
class ServerCreateSessionResponse {
    var accessJwt: String? = null
    var refreshJwt: String? = null
    var handle: String? = null
    var did: String? = null
}
