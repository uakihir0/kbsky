package work.socialhub.kbsky.model.app.bsky.graph

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.RecordUnion

@Serializable
class GraphStarterPack : RecordUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GraphStarterPack
    }

    @SerialName("\$type")
    override var type = TYPE

    /** Display name for starter pack; can not be empty. */
    var name: String? = null

    var description: String? = null
    var descriptionFacets: List<RichtextFacet>? = null

    /** Reference (AT-URI) to the list record. */
    var list: String? = null

    var feeds: List<GraphStarterPackFeedItem>? = null
    var createdAt: String? = null
}