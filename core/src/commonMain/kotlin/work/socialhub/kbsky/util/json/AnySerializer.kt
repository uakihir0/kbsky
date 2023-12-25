package work.socialhub.kbsky.util.json

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

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
            else -> throw IllegalStateException("Can't serialize unknown type: $this")
        }
    }
}
