package work.socialhub.kbsky.model.app.bsky.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class RichtextFacetTag(
    @SerialName("\$type")
    override var type: String = TYPE,
    var tag: String,
) : RichtextFacetFeatureUnion() {

    companion object {
        const val TYPE = BlueskyTypes.RichtextFacet + "#tag"
    }
}