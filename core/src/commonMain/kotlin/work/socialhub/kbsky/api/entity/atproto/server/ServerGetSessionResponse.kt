package work.socialhub.kbsky.api.entity.atproto.server

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.atproto.server.DidDocUnion

@Serializable
class ServerGetSessionResponse {
    lateinit var handle: String
    lateinit var did: String

    var email: String? = null
    var emailConfirmed: Boolean? = null
    var didDoc: DidDocUnion? = null
}
