package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

/**
 * Request to fetch an author's feed.
 */
data class FeedGetAuthorFeedRequest(
    override val auth: AuthProvider,
    var actor: String = "",
    var limit: Int? = null,
    var cursor: String? = null,
    var filter: Filter? = null,
    var includePins: Boolean = false,
) : AuthRequest(auth), MapRequest {

    enum class Filter(val value: String) {
        PostsWithReplies("posts_with_replies"),
        PostsNoReplies("posts_no_replies"),
        PostsWithMedia("posts_with_media"),
        PostsWithVideo("posts_with_video"),
        PostsAndAuthorThreads("posts_and_author_threads")
    }

    override fun toMap(): Map<String, Any> =
        mutableMapOf<String, Any>().also {
            it.addParam("actor", actor)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
            it.addParam("filter", filter?.value)
            it.addParam("includePins", includePins)
        }
}
