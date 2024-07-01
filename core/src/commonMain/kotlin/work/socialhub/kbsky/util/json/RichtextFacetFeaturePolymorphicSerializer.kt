package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacetFeatureUnion
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacetLink
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacetMention
import work.socialhub.kbsky.model.app.bsky.richtext.RichtextFacetTag
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object RichtextFacetFeaturePolymorphicSerializer :
    JsonContentPolymorphicSerializer<RichtextFacetFeatureUnion>(
        RichtextFacetFeatureUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<RichtextFacetFeatureUnion> {
        return when (val type = element.type()) {
            RichtextFacetLink.TYPE -> RichtextFacetLink.serializer()
            RichtextFacetMention.TYPE -> RichtextFacetMention.serializer()
            RichtextFacetTag.TYPE -> RichtextFacetTag.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (RichtextFacetFeatureUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : RichtextFacetFeatureUnion() {
        override var type: String = "Unknown"
    }
}