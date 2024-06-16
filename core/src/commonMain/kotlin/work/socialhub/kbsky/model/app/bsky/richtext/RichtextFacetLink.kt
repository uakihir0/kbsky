package work.socialhub.kbsky.model.app.bsky.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacetLink.Companion.TYPE

/**
 * A facet feature for links.
 */
@Serializable
class RichtextFacetLink : RichtextFacetFeatureUnion() {

    companion object {
        const val TYPE = BlueskyTypes.RichtextFacet + "#link"
    }

    @SerialName("\$type")
    override var type = TYPE

    var uri: String? = null
}
