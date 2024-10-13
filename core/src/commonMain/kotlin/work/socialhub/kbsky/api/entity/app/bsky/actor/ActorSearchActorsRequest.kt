package work.socialhub.kbsky.api.entity.app.bsky.actor

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class ActorSearchActorsRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    /** DEPRECATED: use 'q' instead. */
    var term: String? = null

    /** Search query string. Syntax, phrase, boolean, and faceting is unspecified, but Lucene query syntax is recommended. */
    var q: String? = null

    /** 1-100 default:25*/
    var limit: Int? = null

    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("term", term)
            it.addParam("q", q)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
