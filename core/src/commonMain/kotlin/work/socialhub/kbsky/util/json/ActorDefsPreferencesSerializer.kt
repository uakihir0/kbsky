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
import work.socialhub.kbsky.model.bsky.actor.ActorDefsAdultContentPref
import work.socialhub.kbsky.model.bsky.actor.ActorDefsContentLabelPref
import work.socialhub.kbsky.model.bsky.actor.ActorDefsPreferencesUnion
import work.socialhub.kbsky.model.bsky.actor.ActorDefsSavedFeedsPref

/**
 * @see ActorDefsPreferencesUnion
 */
object ActorDefsPreferencesSerializer : KSerializer<ActorDefsPreferencesUnion> {

    override val descriptor: SerialDescriptor
        get() =
            buildClassSerialDescriptor("ActorDefsPreferencesUnion") {
                element<String>("\$type")
            }

    override fun deserialize(decoder: Decoder): ActorDefsPreferencesUnion {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        require(element is JsonObject)
        return when (element["\$type"]?.jsonPrimitive?.content) {

            ActorDefsAdultContentPref.TYPE ->
                decoder.decodeSerializableValue(ActorDefsAdultContentPref.serializer())

            ActorDefsContentLabelPref.TYPE ->
                decoder.decodeSerializableValue(ActorDefsContentLabelPref.serializer())

            ActorDefsSavedFeedsPref.TYPE ->
                decoder.decodeSerializableValue(ActorDefsSavedFeedsPref.serializer())

            else -> throw IllegalStateException("unknown type")
        }
    }

    override fun serialize(encoder: Encoder, value: ActorDefsPreferencesUnion) {
        throw NotImplementedError()
    }
}
