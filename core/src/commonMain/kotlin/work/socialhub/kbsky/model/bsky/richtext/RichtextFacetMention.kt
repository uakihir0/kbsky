package work.socialhub.kbsky.model.bsky.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A facet feature for actor mentions.
 */
@Serializable
class RichtextFacetMention : RichtextFacetFeatureUnion() {

    companion object {
        const val TYPE = BlueskyTypes.RichtextFacet + "#mention"
    }

    @SerialName("\$type")
    override var type = TYPE

    var did: String? = null

}
