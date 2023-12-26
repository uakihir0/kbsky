package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetFeatureUnion
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetLink
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetMention

object RichtextFacetFeaturePolymorphicSerializer :
    JsonContentPolymorphicSerializer<RichtextFacetFeatureUnion>(
        RichtextFacetFeatureUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<RichtextFacetFeatureUnion> {
        return when (element.jsonObject["\$type"]?.jsonPrimitive?.content) {
            RichtextFacetLink.TYPE -> RichtextFacetLink.serializer()
            RichtextFacetMention.TYPE -> RichtextFacetMention.serializer()
            else -> throw Exception("Unknown Item type")
        }
    }
}