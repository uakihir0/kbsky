package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

data class FeedSearchPostsRequest(
    override val auth: AuthProvider,
    /** Search query string; syntax, phrase, boolean, and faceting is unspecified, but Lucene query syntax is recommended. */
    var q: String,
    // [1-100] default: 25
    var limit: Int? = null,
    /** Optional pagination mechanism; may not necessarily allow scrolling through entire result set. */
    var cursor: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("q", q)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}