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
import work.socialhub.kbsky.model.bsky.actor.ActorProfile
import work.socialhub.kbsky.model.bsky.feed.FeedLike
import work.socialhub.kbsky.model.bsky.feed.FeedPost
import work.socialhub.kbsky.model.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.bsky.graph.GraphBlock
import work.socialhub.kbsky.model.bsky.graph.GraphFollow
import work.socialhub.kbsky.model.share.RecordUnion

/**
 * @see RecordUnion
 */
object RecordSerializer : KSerializer<RecordUnion> {

    override val descriptor: SerialDescriptor
        get() =
            buildClassSerialDescriptor("RecordUnion") {
                element<String>("\$type")
            }

    override fun deserialize(decoder: Decoder): RecordUnion {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()

        require(element is JsonObject)
        return when (element["\$type"]?.jsonPrimitive?.content) {

            ActorProfile.TYPE ->
                decoder.decodeSerializableValue(ActorProfile.serializer())

            GraphFollow.TYPE ->
                decoder.decodeSerializableValue(GraphFollow.serializer())

            GraphBlock.TYPE ->
                decoder.decodeSerializableValue(GraphBlock.serializer())

            FeedLike.TYPE ->
                decoder.decodeSerializableValue(FeedLike.serializer())

            FeedPost.TYPE ->
                decoder.decodeSerializableValue(FeedPost.serializer())

            FeedRepost.TYPE ->
                decoder.decodeSerializableValue(FeedPost.serializer())

            else -> throw IllegalStateException("unknown type")
        }
    }

    override fun serialize(encoder: Encoder, value: RecordUnion) {
        throw NotImplementedError()
    }
}