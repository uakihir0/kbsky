package work.socialhub.kbsky.model.app.bsky.graph


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * List
 */
@Serializable
@JsExport
data class GraphDefsListViewBasic(
    @SerialName("\$type")
    var type: String = TYPE,
    var uri: String? = null,
    var cid: String? = null,
    var name: String? = null,
    var purpose: String? = null,
    var avatar: String? = null,
    var viewer: GraphDefsListViewerState? = null,
    var indexedAt: String? = null,
) {
    companion object {
        const val TYPE = BlueskyTypes.GraphDefs + "#listViewBasic"
    }
}
