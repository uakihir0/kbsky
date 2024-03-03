package work.socialhub.kbsky.api.entity.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.model.bsky.graph.GraphList

class GraphCreateListRequest(
    accessJwt: String,
    private val purpose: String = "app.bsky.graph.defs#curatelist",
    private val name: String,
    private val description: String?,
    override var createdAt: String? = null
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("purpose", purpose)
            it.addParam("name", name)
            it.addParam("description", description)
            it.addParam("createdAt", createdAt())
        }
    }

    fun toRecord(): GraphList {
        return GraphList().also {
            it.purpose = purpose
            it.name = name
            it.description = description
            it.createdAt = createdAt()
        }
    }
}
