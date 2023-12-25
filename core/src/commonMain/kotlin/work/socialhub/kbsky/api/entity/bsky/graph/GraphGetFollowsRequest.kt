package work.socialhub.kbsky.api.entity.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class GraphGetFollowsRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var actor: String? = null
    var limit: Int? = null
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("actor", actor)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
