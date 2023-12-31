package work.socialhub.kbsky.api.entity.bsky.feed

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.internal.share._InternalUtility.toJson
import work.socialhub.kbsky.model.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.bsky.feed.FeedPost
import work.socialhub.kbsky.model.bsky.feed.FeedPostReplyRef
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacet

class FeedPostRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    lateinit var text: String

    var facets: List<RichtextFacet>? = null
    var reply: FeedPostReplyRef? = null
    var embed: EmbedUnion? = null
    override var createdAt: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("text", text)
            it.addParam("facets", toJson(facets))
            it.addParam("reply", toJson(reply))
            it.addParam("embed", toJson(embed))
            it.addParam("createdAt", createdAt())
        }
    }

    fun toPost(): FeedPost {
        val post = FeedPost()
        post.text = text
        post.facets = facets
        post.reply = reply
        post.embed = embed
        post.createdAt = createdAt()
        return post
    }
}