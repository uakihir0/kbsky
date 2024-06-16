package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.graph.GraphListItem.Companion.TYPE
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class GraphListItem : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GraphListItem
    }

    @SerialName("\$type")
    override var type = TYPE

    // user did
    var subject: String? = null

    // list uri
    var list: String? = null

    var createdAt: String? = null
}
