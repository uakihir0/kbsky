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
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewBlocked
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewNotFound
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewRecord
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewUnion

/**
 * @see EmbedRecordViewUnion
 */
object EmbedRecordViewSerializer : KSerializer<EmbedRecordViewUnion> {

    override val descriptor: SerialDescriptor
        get() =
            buildClassSerialDescriptor("EmbedRecordViewUnion") {
                element<String>("\$type")
            }

    override fun deserialize(decoder: Decoder): EmbedRecordViewUnion {

        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        require(element is JsonObject)
        return when (element["\$type"]?.jsonPrimitive?.content) {

            EmbedRecordViewRecord.TYPE ->
                decoder.decodeSerializableValue(EmbedRecordViewRecord.serializer())

            EmbedRecordViewNotFound.TYPE ->
                decoder.decodeSerializableValue(EmbedRecordViewNotFound.serializer())

            EmbedRecordViewBlocked.TYPE ->
                decoder.decodeSerializableValue(EmbedRecordViewBlocked.serializer())

            else -> throw IllegalStateException("unknown type")
        }
    }

    override fun serialize(encoder: Encoder, value: EmbedRecordViewUnion) {
        throw NotImplementedError()
    }
}