package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewBlocked
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewDetached
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewNotFound
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewRecord
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewUnion
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsGeneratorView
import work.socialhub.kbsky.model.app.bsky.graph.GraphDefsListView
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
            EmbedRecordViewDetached.TYPE -> EmbedRecordViewDetached.serializer()
            FeedDefsGeneratorView.TYPE -> FeedDefsGeneratorView.serializer()
            GraphDefsListView.TYPE -> GraphDefsListView.serializer()
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