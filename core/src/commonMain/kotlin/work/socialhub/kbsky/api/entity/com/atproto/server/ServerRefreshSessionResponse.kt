package work.socialhub.kbsky.api.entity.com.atproto.server

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion

@Serializable
class ServerRefreshSessionResponse {
    lateinit var accessJwt: String
    lateinit var refreshJwt: String
    lateinit var handle: String
    lateinit var did: String

    var didDoc: DidDocUnion? = null
    var active: Boolean? = null
}
