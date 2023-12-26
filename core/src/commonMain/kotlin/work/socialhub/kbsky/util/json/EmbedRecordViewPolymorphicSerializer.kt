package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewBlocked
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewNotFound
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewRecord
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewUnion

object EmbedRecordViewPolymorphicSerializer :
    JsonContentPolymorphicSerializer<EmbedRecordViewUnion>(
        EmbedRecordViewUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<EmbedRecordViewUnion> {
        return when (element.jsonObject["\$type"]?.jsonPrimitive?.content) {
            EmbedRecordViewRecord.TYPE -> EmbedRecordViewRecord.serializer()
            EmbedRecordViewNotFound.TYPE -> EmbedRecordViewNotFound.serializer()
            EmbedRecordViewBlocked.TYPE -> EmbedRecordViewBlocked.serializer()
            else -> throw Exception("Unknown Item type")
        }
    }
}