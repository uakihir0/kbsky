package work.socialhub.kbsky.model.app.bsky.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacetTag.Companion.TYPE

@Serializable
class RichtextFacetTag : RichtextFacetFeatureUnion() {

    companion object {
        const val TYPE = BlueskyTypes.RichtextFacet + "#tag"
    }

    @SerialName("\$type")
    override var type = TYPE

    lateinit var tag: String
}