package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class GraphGetMutesRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var limit: Int? = null
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
