package work.socialhub.kbsky.model.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class GraphList : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GraphList
    }

    @SerialName("\$type")
    override var type = TYPE

    var purpose: String? = null

    var name: String? = null

    var description: String? = null

    var createdAt: String? = null
}
