package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.bsky.embed.*
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object EmbedPolymorphicSerializer :
    JsonContentPolymorphicSerializer<EmbedUnion>(
        EmbedUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<EmbedUnion> {
        return when (val type = element.type()) {
            BlueskyTypes.EmbedImages -> EmbedImages.serializer()
            BlueskyTypes.EmbedExternal -> EmbedExternal.serializer()
            BlueskyTypes.EmbedRecord -> EmbedRecord.serializer()
            BlueskyTypes.EmbedRecordWithMedia -> EmbedRecordWithMedia.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (EmbedUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : EmbedUnion() {
        override var type: String = "unknown"
    }
}