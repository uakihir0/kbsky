package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.embed.*

object EmbedViewPolymorphicSerializer :
    JsonContentPolymorphicSerializer<EmbedViewUnion>(
        EmbedViewUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<EmbedViewUnion> {
        return when (element.jsonObject["\$type"]?.jsonPrimitive?.content) {
            EmbedExternalView.TYPE -> EmbedExternalView.serializer()
            EmbedImagesView.TYPE -> EmbedImagesView.serializer()
            EmbedRecordView.TYPE -> EmbedRecordView.serializer()
            EmbedRecordWithMediaView.TYPE -> EmbedRecordWithMediaView.serializer()
            else -> throw Exception("Unknown Item type")
        }
    }
}