package work.socialhub.kbsky.model.bsky.richtext

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

/**
 * A facet feature for links.
 */
@Serializable
class RichtextFacetLink : RichtextFacetFeatureUnion() {

    companion object {
        const val TYPE = BlueskyTypes.RichtextFacet + "#link"
    }

    override var type = TYPE

    var uri: String? = null
}
