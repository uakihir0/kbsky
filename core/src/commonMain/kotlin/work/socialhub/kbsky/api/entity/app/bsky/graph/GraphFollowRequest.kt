package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.model.app.bsky.graph.GraphFollow

class GraphFollowRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    var subject: String? = null
    override var createdAt: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("subject", subject)
            it.addParam("createdAt", createdAt())
        }
    }

    fun toFollow(): GraphFollow {
        val follow = GraphFollow()
        follow.subject = subject
        follow.createdAt = createdAt()
        return follow
    }
}
