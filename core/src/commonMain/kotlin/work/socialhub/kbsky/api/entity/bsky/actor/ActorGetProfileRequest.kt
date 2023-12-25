package work.socialhub.kbsky.api.entity.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ActorGetProfileRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var actor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("actor", actor)
        }
    }
}
