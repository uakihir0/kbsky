package work.socialhub.kbsky.model.bsky.richtext

import kotlinx.serialization.SerialName

/**
 * @see RichtextFacetLink
 * @see RichtextFacetMention
 */
interface RichtextFacetFeatureUnion {
    @SerialName("\$type")
    val type: String
}
