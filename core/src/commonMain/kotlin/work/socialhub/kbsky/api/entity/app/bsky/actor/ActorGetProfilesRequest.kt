package work.socialhub.kbsky.api.entity.app.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ActorGetProfilesRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var actors: List<String>? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("actors", actors)
        }
    }
}
