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
import work.socialhub.kbsky.model.bsky.feed.FeedDefsNotFoundPost
import work.socialhub.kbsky.model.bsky.feed.FeedDefsThreadUnion
import work.socialhub.kbsky.model.bsky.feed.FeedDefsThreadViewPost

/**
 * @see FeedDefsThreadUnion
 */
object FeedDefsThreadSerializer : KSerializer<FeedDefsThreadUnion> {

    override val descriptor: SerialDescriptor
        get() =
            buildClassSerialDescriptor("FeedDefsThreadUnion") {
                element<String>("\$type")
            }

    override fun deserialize(decoder: Decoder): FeedDefsThreadUnion {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        require(element is JsonObject)
        return when (element["\$type"]?.jsonPrimitive?.content) {

            FeedDefsThreadViewPost.TYPE ->
                decoder.decodeSerializableValue(FeedDefsThreadViewPost.serializer())

            FeedDefsNotFoundPost.TYPE ->
                decoder.decodeSerializableValue(FeedDefsNotFoundPost.serializer())

            else -> throw IllegalStateException("unknown type")
        }
    }

    override fun serialize(encoder: Encoder, value: FeedDefsThreadUnion) {
        throw NotImplementedError()
    }
}
