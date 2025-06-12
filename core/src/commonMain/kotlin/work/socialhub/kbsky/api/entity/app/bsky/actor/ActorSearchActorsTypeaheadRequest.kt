package work.socialhub.kbsky.api.entity.app.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

data class ActorSearchActorsTypeaheadRequest(
    override val auth: AuthProvider,
    /** DEPRECATED: use 'q' instead. */
    var term: String? = null,
    /** Search query prefix; not a full query string. */
    var q: String? = null,
    /** 1-100 default:10*/
    var limit: Int? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("term", term)
            it.addParam("q", q)
            it.addParam("limit", limit)
        }
    }
}
