package work.socialhub.kbsky.api.entity.com.atproto.server

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.com.atproto.server.DidDocUnion

@Serializable
@JsExport
data class ServerRefreshSessionResponse(
    var accessJwt: String = "",
    var refreshJwt: String = "",
    var handle: String = "",
    var did: String = "",
    var didDoc: DidDocUnion? = null,
    var active: Boolean? = null,
)
