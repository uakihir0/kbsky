package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.RKeyRequest

class GraphDeleteBlockRequest(
    accessJwt: String
) : AuthRequest(accessJwt), RKeyRequest {

    override var uri: String? = null
    override var rkey: String? = null
}
