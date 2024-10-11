package work.socialhub.kbsky.api.entity.app.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class ActorGetPreferencesRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mapOf()
    }
}
