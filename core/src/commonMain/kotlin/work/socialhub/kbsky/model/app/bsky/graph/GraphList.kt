package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.com.atproto.label.LabelDefsSelfLabels
import work.socialhub.kbsky.model.share.Blob
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class GraphList(
    val purpose: String? = null,
    val name: String? = null,
    val description: String? = null,
    val descriptionFacets: List<RichtextFacet>? = null,
    val avatar: Blob? = null,
    var labels: LabelDefsSelfLabels? = null,
    val createdAt: String? = null,
) : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GraphList
    }

    @SerialName("\$type")
    override var type = TYPE
}
