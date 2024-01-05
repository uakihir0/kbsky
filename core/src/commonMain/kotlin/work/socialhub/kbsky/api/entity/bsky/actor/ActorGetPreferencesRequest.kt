package work.socialhub.kbsky.api.entity.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ActorGetPreferencesRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mapOf()
    }
}
