package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.feed.FeedPostgateDisableRule
import work.socialhub.kbsky.model.app.bsky.feed.FeedPostgateEmbeddingRulesUnion
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object PostgateEmbeddingRulesUnionPolymorphicSerializer :
    JsonContentPolymorphicSerializer<FeedPostgateEmbeddingRulesUnion>(
        FeedPostgateEmbeddingRulesUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<FeedPostgateEmbeddingRulesUnion> {
        return when (val type = element.type()) {
            FeedPostgateDisableRule.TYPE -> FeedPostgateDisableRule.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (PostgateEmbeddingRulesUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : FeedPostgateEmbeddingRulesUnion() {
        override var type: String = "unknown"
    }
}