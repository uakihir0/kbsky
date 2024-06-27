package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.api.entity.share.RecordRequest
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsSelfLabels
import work.socialhub.kbsky.model.app.bsky.graph.GraphList
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.Blob

class GraphCreateListRequest(
    accessJwt: String,
    private val purpose: String = "app.bsky.graph.defs#curatelist",
    private val name: String,
    private val description: String?,
    private val descriptionFacets: List<RichtextFacet>? = null,
    private val avatar: Blob? = null,
    private var labels: LabelDefsSelfLabels? = null,
    override var createdAt: String? = null
) : AuthRequest(accessJwt), MapRequest, RecordRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("purpose", purpose)
            it.addParam("name", name)
            it.addParam("description", description)
            it.addParam("descriptionFacets", descriptionFacets)
            it.addParam("avatar", avatar)
            it.addParam("labels", labels)
            it.addParam("createdAt", createdAt())
        }
    }

    fun toRecord(): GraphList {
        return GraphList(
            purpose = purpose,
            name = name,
            description = description,
            descriptionFacets = descriptionFacets,
            avatar = avatar,
            labels = labels,
            createdAt = createdAt()
        )
    }
}
