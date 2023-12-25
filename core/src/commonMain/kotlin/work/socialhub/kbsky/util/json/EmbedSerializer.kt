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
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.bsky.embed.*

/**
 * @see EmbedUnion
 */
object EmbedSerializer : KSerializer<EmbedUnion> {

    override val descriptor: SerialDescriptor
        get() =
            buildClassSerialDescriptor("EmbedUnion") {
                element<String>("\$type")
            }

    override fun deserialize(decoder: Decoder): EmbedUnion {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        require(element is JsonObject)
        return when (element["\$type"]?.jsonPrimitive?.content) {

            BlueskyTypes.EmbedImages ->
                decoder.decodeSerializableValue(EmbedImages.serializer())

            BlueskyTypes.EmbedExternal ->
                decoder.decodeSerializableValue(EmbedExternal.serializer())

            BlueskyTypes.EmbedRecord ->
                decoder.decodeSerializableValue(EmbedRecord.serializer())

            BlueskyTypes.EmbedRecordWithMedia ->
                decoder.decodeSerializableValue(EmbedRecordWithMedia.serializer())

            else -> throw IllegalStateException("unknown type")
        }
    }

    override fun serialize(encoder: Encoder, value: EmbedUnion) {

        when (value) {
            is EmbedImages ->
                encoder.encodeSerializableValue(EmbedImages.serializer(), value)

            is EmbedExternal ->
                encoder.encodeSerializableValue(EmbedExternal.serializer(), value)

            is EmbedRecord ->
                encoder.encodeSerializableValue(EmbedRecord.serializer(), value)

            is EmbedRecordWithMedia ->
                encoder.encodeSerializableValue(EmbedRecordWithMedia.serializer(), value)
        }

        throw IllegalStateException("unknown type")
    }
}