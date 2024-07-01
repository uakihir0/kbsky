package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * List
 */
@Serializable
class GraphDefsListViewBasic {

    companion object {
        const val TYPE = BlueskyTypes.GraphDefs + "#listViewBasic"
    }

    @SerialName("\$type")
    var type = TYPE

    lateinit var uri: String
    lateinit var cid: String
    lateinit var name: String
    lateinit var purpose: String
    var avatar: String? = null
    var viewer: GraphDefsListViewerState? = null
    var indexedAt: String? = null
}
