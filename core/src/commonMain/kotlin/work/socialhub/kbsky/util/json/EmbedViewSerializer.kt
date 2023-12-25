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
import work.socialhub.kbsky.model.bsky.embed.*

object EmbedViewSerializer : KSerializer<EmbedViewUnion> {

    override val descriptor: SerialDescriptor
        get() =
            buildClassSerialDescriptor("EmbedViewUnion") {
                element<String>("\$type")
            }

    override fun deserialize(decoder: Decoder): EmbedViewUnion {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        require(element is JsonObject)
        return when (element["\$type"]?.jsonPrimitive?.content) {

            EmbedExternalView.TYPE ->
                decoder.decodeSerializableValue(EmbedExternalView.serializer())

            EmbedImagesView.TYPE ->
                decoder.decodeSerializableValue(EmbedImagesView.serializer())

            EmbedRecordView.TYPE ->
                decoder.decodeSerializableValue(EmbedRecordView.serializer())

            EmbedRecordWithMediaView.TYPE ->
                decoder.decodeSerializableValue(EmbedRecordWithMediaView.serializer())

            else -> throw IllegalStateException("unknown type")
        }
    }

    override fun serialize(encoder: Encoder, value: EmbedViewUnion) {
        throw NotImplementedError()
    }
}
