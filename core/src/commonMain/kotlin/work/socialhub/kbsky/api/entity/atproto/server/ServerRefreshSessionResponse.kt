package work.socialhub.kbsky.api.entity.atproto.server

import kotlinx.serialization.Serializable

@Serializable
class ServerRefreshSessionResponse {
    var handle: String? = null
    var did: String? = null
}
