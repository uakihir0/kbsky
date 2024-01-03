package work.socialhub.kbsky.model.bsky.richtext

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes

@Serializable
class RichtextFacetTag : RichtextFacetFeatureUnion() {

    companion object {
        const val TYPE = BlueskyTypes.RichtextFacet + "#tag"
    }

    override var type = TYPE

    lateinit var tag: String
}