package work.socialhub.kbsky.model.app.bsky.graph


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacet
import work.socialhub.kbsky.model.share.RecordUnion
import kotlin.js.JsExport

@Serializable
@JsExport
data class GraphStarterPack(
    @SerialName("\$type")
    override var type: String = TYPE,
    var name: String? = null,
    var description: String? = null,
    var descriptionFacets: List<RichtextFacet>? = null,
    var list: String? = null,
    var feeds: List<GraphStarterPackFeedItem>? = null,
    var createdAt: String? = null,
) : RecordUnion() {
    companion object {
        const val TYPE = BlueskyTypes.GraphStarterPack
    }
}
