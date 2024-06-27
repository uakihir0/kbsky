package work.socialhub.kbsky.api.entity.app.bsky.graph

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsSelfLabels
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.Blob

class GraphEditListRequest(
    accessJwt: String,
    val listUri: String,
    val name: String,
    val description: String?,
    val descriptionFacets: List<RichtextFacet>? = null,
    val avatar: Blob? = null,
    var labels: LabelDefsSelfLabels? = null,
) : AuthRequest(accessJwt)