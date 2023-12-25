package work.socialhub.kbsky.api.entity.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ActorSearchActorsRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var term: String? = null
    var limit: Int? = null
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("term", term)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
