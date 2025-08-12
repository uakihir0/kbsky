package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgateAllowUnion
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgateFollowerRule
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgateFollowingRule
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgateListRule
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgateMentionRule
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ThreadgateAllowUnionPolymorphicSerializer :
    JsonContentPolymorphicSerializer<FeedThreadgateAllowUnion>(
        FeedThreadgateAllowUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<FeedThreadgateAllowUnion> {
        return when (val type = element.type()) {
            FeedThreadgateMentionRule.TYPE -> FeedThreadgateMentionRule.serializer()
            FeedThreadgateFollowingRule.TYPE -> FeedThreadgateFollowingRule.serializer()
            FeedThreadgateFollowerRule.TYPE -> FeedThreadgateFollowerRule.serializer()
            FeedThreadgateListRule.TYPE -> FeedThreadgateListRule.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ThreadgateAllowUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : FeedThreadgateAllowUnion() {
        override var type: String = "unknown"
    }
}