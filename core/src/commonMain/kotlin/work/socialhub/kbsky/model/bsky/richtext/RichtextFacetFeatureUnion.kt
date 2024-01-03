package work.socialhub.kbsky.model.bsky.richtext

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.RichtextFacetFeaturePolymorphicSerializer

/**
 * @see RichtextFacetLink
 * @see RichtextFacetMention
 * @see RichtextFacetTag
 */
@Serializable(with = RichtextFacetFeaturePolymorphicSerializer::class)
abstract class RichtextFacetFeatureUnion {
    @SerialName("\$type")
    abstract var type: String

    fun link() = this as? RichtextFacetLink
    fun mention() = this as? RichtextFacetMention
    fun tag() = this as? RichtextFacetTag
}
