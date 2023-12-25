package work.socialhub.kbsky.util.json

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetFeatureUnion
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetLink
import work.socialhub.kbsky.model.bsky.richtext.RichtextFacetMention

/**
 * @see RichtextFacetFeatureUnion
 */
object RichtextFacetFeatureSerializer : KSerializer<RichtextFacetFeatureUnion> {

    override val descriptor: SerialDescriptor
        get() =
            buildClassSerialDescriptor("RichtextFacetFeatureUnion") {
                element<String>("\$type")
            }

    override fun deserialize(decoder: Decoder): RichtextFacetFeatureUnion {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        require(element is JsonObject)
        return when (element["\$type"]?.jsonPrimitive?.content) {

            RichtextFacetLink.TYPE ->
                decoder.decodeSerializableValue(RichtextFacetLink.serializer())

            RichtextFacetMention.TYPE ->
                decoder.decodeSerializableValue(RichtextFacetMention.serializer())

            else -> throw IllegalStateException("unknown type")
        }
    }

    override fun serialize(encoder: Encoder, value: RichtextFacetFeatureUnion) {
        when (value) {
            is RichtextFacetLink ->
                encoder.encodeSerializableValue(RichtextFacetLink.serializer(), value)

            is RichtextFacetMention ->
                encoder.encodeSerializableValue(RichtextFacetMention.serializer(), value)
        }
    }
}