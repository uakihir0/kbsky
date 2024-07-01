package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

/**
 * A block.
 */
@Serializable
class GraphBlock : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GraphBlock
    }

    @SerialName("\$type")
    override var type = TYPE

    var subject: String? = null
    var createdAt: String? = null
}
