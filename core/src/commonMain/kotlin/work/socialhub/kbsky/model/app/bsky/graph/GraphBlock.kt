package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

/**
 * A block.
 */
@Serializable
data class GraphBlock(
    @SerialName("\$type")
    override var type: String = TYPE,
    var subject: String? = null,
    var createdAt: String? = null,
) : RecordUnion() {
    companion object {
        const val TYPE = BlueskyTypes.GraphBlock
    }
}
