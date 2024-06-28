package work.socialhub.kbsky.util.json

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*
import work.socialhub.kbsky.model.app.bsky.actor.ActorProfile
import work.socialhub.kbsky.model.app.bsky.feed.FeedLike
import work.socialhub.kbsky.model.app.bsky.feed.FeedPost
import work.socialhub.kbsky.model.app.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgate
import work.socialhub.kbsky.model.app.bsky.graph.GraphBlock
import work.socialhub.kbsky.model.app.bsky.graph.GraphFollow
import work.socialhub.kbsky.model.app.bsky.graph.GraphList
import work.socialhub.kbsky.model.app.bsky.graph.GraphListItem
import work.socialhub.kbsky.model.chat.bsky.convo.ChatConvoDefsMessageInput

object AnySerializer : KSerializer<Any> {

    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("Any")

    override fun deserialize(decoder: Decoder): Any {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()
        return element.toAny()
    }

    private fun JsonElement.toAny(): Any {
        when (this) {
            is JsonPrimitive -> {
                return when {
                    this.isString -> this.content
                    this.intOrNull != null -> this.int
                    this.longOrNull != null -> this.long
                    this.floatOrNull != null -> this.float
                    this.doubleOrNull != null -> this.double
                    this.booleanOrNull != null -> this.boolean
                    else -> throw IllegalStateException("Can't deserialize unknown type: $this")
                }
            }

            is JsonArray -> {
                return this.map { it.toAny() }
            }

            is JsonObject -> {
                return this.map { it.key to it.value.toAny() }.toMap()
            }
        }
    }

    override fun serialize(encoder: Encoder, value: Any) {
        when (value) {
            is Int -> encoder.encodeInt(value)
            is Long -> encoder.encodeLong(value)
            is Short -> encoder.encodeShort(value)
            is Float -> encoder.encodeFloat(value)
            is Double -> encoder.encodeDouble(value)
            is String -> encoder.encodeString(value)
            is Boolean -> encoder.encodeBoolean(value)
            is Enum<*> -> encoder.encodeString(this.toString())

            // KMP のリフレクションが full に対応した時に修正
            // ここでこのライブラリで必要なクラスをひたすら列挙
            // 標準ライブラリはどうやってアノテーションを見ている？
            is ActorProfile -> encoder.encodeSerializableValue(ActorProfile.serializer(), value)
            is GraphFollow -> encoder.encodeSerializableValue(GraphFollow.serializer(), value)
            is GraphListItem -> encoder.encodeSerializableValue(GraphListItem.serializer(), value)
            is GraphList -> encoder.encodeSerializableValue(GraphList.serializer(), value)
            is GraphBlock -> encoder.encodeSerializableValue(GraphBlock.serializer(), value)
            is FeedLike -> encoder.encodeSerializableValue(FeedLike.serializer(), value)
            is FeedPost -> encoder.encodeSerializableValue(FeedPost.serializer(), value)
            is FeedRepost -> encoder.encodeSerializableValue(FeedRepost.serializer(), value)
            is FeedThreadgate -> encoder.encodeSerializableValue(FeedThreadgate.serializer(), value)
            is ChatConvoDefsMessageInput -> encoder.encodeSerializableValue(ChatConvoDefsMessageInput.serializer(), value)

            else -> {
                println("Can't serialize unknown type: ${value::class}")
            }
        }
    }
}
