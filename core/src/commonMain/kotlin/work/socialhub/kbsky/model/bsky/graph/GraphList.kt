package work.socialhub.kbsky.model.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
data class GraphList(
    val purpose: String? = null,
    val name: String? = null,
    val description: String? = null,
    val createdAt: String? = null,
) : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GraphList
    }

    @SerialName("\$type")
    override var type = TYPE
}
