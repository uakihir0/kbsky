package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.model.app.bsky.graph.GraphListItem

class GraphAddUserToListRequest(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    var userDid: String? = null
    var listUri: String? = null
    override var createdAt: String? = createdAt()

    override fun toMap(): Map<String, Any> {
        return emptyMap()
    }

    fun toListItem(): work.socialhub.kbsky.model.app.bsky.graph.GraphListItem {
        return work.socialhub.kbsky.model.app.bsky.graph.GraphListItem().also {
            it.subject = userDid
            it.list = listUri
            it.createdAt = createdAt()
        }
    }
}
