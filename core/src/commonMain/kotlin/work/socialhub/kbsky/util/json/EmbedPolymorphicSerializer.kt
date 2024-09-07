package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.app.bsky.embed.EmbedExternal
import work.socialhub.kbsky.model.app.bsky.embed.EmbedImages
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecord
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordWithMedia
import work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.app.bsky.embed.EmbedVideo
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
            BlueskyTypes.EmbedVideo -> EmbedVideo.serializer()
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