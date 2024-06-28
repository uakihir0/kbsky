package work.socialhub.kbsky.api.entity.app.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class FeedGetAuthorFeedRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    lateinit var actor: String

    var limit: Int? = null
    var cursor: String? = null

    enum class Filter(val value: String) {
        PostsWithReplies("posts_with_replies"),
        PostsNoReplies("posts_no_replies"),
        PostsWithMedia("posts_with_media"),
        PostsAndAuthorThreads("posts_and_author_threads")
    }

    var filter: Filter? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("actor", actor)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
            it.addParam("filter", filter?.value)
        }
    }
}
