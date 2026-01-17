package work.socialhub.kbsky.model.app.bsky.graph


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewUnion
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import kotlin.js.JsExport

/**
 * List
 */
@Serializable
@JsExport
data class GraphDefsListView(
    @SerialName("\$type")
    override var type: String = TYPE,
    var uri: String? = null,
    var cid: String? = null,
    var creator: ActorDefsProfileView? = null,
    var name: String? = null,
    var purpose: String? = null,
    var description: String? = null,
    var descriptionFacets: List<RichtextFacet> = emptyList(),
    var avatar: String? = null,
    var viewer: GraphDefsListViewerState? = null,
    var indexedAt: String? = null,
) : EmbedRecordViewUnion() {
    companion object {
        const val TYPE = BlueskyTypes.GraphDefs + "#listView"
    }
}
