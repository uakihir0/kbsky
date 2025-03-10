package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * List
 */
@Serializable
data class GraphDefsListViewBasic(
    @SerialName("\$type")
    var type: String = TYPE,

    var uri: String,
    var cid: String,
    var name: String,
    var purpose: String,
    var avatar: String? = null,
    var viewer: GraphDefsListViewerState? = null,
    var indexedAt: String? = null
) {
    companion object {
        const val TYPE = BlueskyTypes.GraphDefs + "#listViewBasic"
    }
}
