package work.socialhub.kbsky.api.entity.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.RKeyRequest

class GraphDeleteFollowRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), RKeyRequest {

    override var uri: String? = null
    override var rkey: String? = null
}
