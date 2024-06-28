package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView

/**
 * List Item
 */
@Serializable
class GraphDefsListItemView {

    companion object {
        const val TYPE = BlueskyTypes.GraphDefs + "#listItemView"
    }

    @SerialName("\$type")
    var type = TYPE

    lateinit var uri: String
    lateinit var subject: ActorDefsProfileView
}
