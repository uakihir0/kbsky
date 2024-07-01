package work.socialhub.kbsky.model.app.bsky.richtext

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

    val asLink get() = this as? RichtextFacetLink
    val asMention get() = this as? RichtextFacetMention
    val asTag get() = this as? RichtextFacetTag
}
