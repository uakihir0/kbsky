package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

/**
 * List Item
 */
@Serializable
data class GraphDefsListItemView(
    @SerialName("\$type")
    var type: String = TYPE,
    var uri: String? = null,
    var subject: ActorDefsProfileView? = null,
) {
    companion object {
        const val TYPE = BlueskyTypes.GraphDefs + "#listItemView"
    }
}
