package work.socialhub.kbsky.api.entity.com.atproto.server

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion

@Serializable
class ServerGetSessionResponse {
    lateinit var handle: String
    lateinit var did: String

    var email: String? = null
    var emailConfirmed: Boolean? = null
    var emailAuthFactor: Boolean? = null
    var didDoc: DidDocUnion? = null
    var active: Boolean? = null
}
