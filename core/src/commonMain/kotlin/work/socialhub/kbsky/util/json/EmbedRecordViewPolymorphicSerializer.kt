package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewBlocked
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewNotFound
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewRecord
import work.socialhub.kbsky.model.bsky.embed.EmbedRecordViewUnion
import work.socialhub.kbsky.model.bsky.feed.FeedDefsGeneratorView
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object EmbedRecordViewPolymorphicSerializer :
    JsonContentPolymorphicSerializer<EmbedRecordViewUnion>(
        EmbedRecordViewUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<EmbedRecordViewUnion> {
        return when (val type = element.type()) {
            EmbedRecordViewRecord.TYPE -> EmbedRecordViewRecord.serializer()
            EmbedRecordViewNotFound.TYPE -> EmbedRecordViewNotFound.serializer()
            EmbedRecordViewBlocked.TYPE -> EmbedRecordViewBlocked.serializer()
            FeedDefsGeneratorView.TYPE -> FeedDefsGeneratorView.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (EmbedRecordViewUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : EmbedRecordViewUnion() {
        override var type: String = "unknown"
    }
}