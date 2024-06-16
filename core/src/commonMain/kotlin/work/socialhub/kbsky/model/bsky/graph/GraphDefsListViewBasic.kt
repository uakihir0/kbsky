package work.socialhub.kbsky.model.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewUnion
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.RecordUnion

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
