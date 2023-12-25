package work.socialhub.kbsky.model.bsky.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class RichtextFacet {

    @SerialName("\$type")
    val type: String = BlueskyTypes.RichtextFacet

    var index: RichtextFacetByteSlice? = null
    var features: MutableList<RichtextFacetFeatureUnion>? = null
}
