package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.bsky.embed.*

object EmbedPolymorphicSerializer :
    JsonContentPolymorphicSerializer<EmbedUnion>(
        EmbedUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<EmbedUnion> {
        return when (element.jsonObject["\$type"]?.jsonPrimitive?.content) {
            BlueskyTypes.EmbedImages -> EmbedImages.serializer()
            BlueskyTypes.EmbedExternal -> EmbedExternal.serializer()
            BlueskyTypes.EmbedRecord -> EmbedRecord.serializer()
            BlueskyTypes.EmbedRecordWithMedia -> EmbedRecordWithMedia.serializer()
            else -> throw Exception("Unknown Item type")
        }
    }
}