package work.socialhub.kbsky.model.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class GraphFollow : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GraphFollow
    }

    @SerialName("\$type")
    override var type = TYPE

    var subject: String? = null
    var createdAt: String? = null
}
