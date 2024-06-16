package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedSearchPostsRequest(
    accessJwt: String,
    /** Search query string; syntax, phrase, boolean, and faceting is unspecified, but Lucene query syntax is recommended. */
    var q: String,
) : AuthRequest(accessJwt), MapRequest {

    // [1-100] default: 25
    var limit: Int? = null

    /** Optional pagination mechanism; may not necessarily allow scrolling through entire result set. */
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("q", q)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}