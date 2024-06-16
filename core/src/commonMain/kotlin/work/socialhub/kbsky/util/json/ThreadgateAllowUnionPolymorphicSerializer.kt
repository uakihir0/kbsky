package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.feed.ThreadgateAllowUnion
import work.socialhub.kbsky.model.app.bsky.feed.ThreadgateFollowingRule
import work.socialhub.kbsky.model.app.bsky.feed.ThreadgateListRule
import work.socialhub.kbsky.model.app.bsky.feed.ThreadgateMentionRule
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ThreadgateAllowUnionPolymorphicSerializer :
    JsonContentPolymorphicSerializer<ThreadgateAllowUnion>(
        ThreadgateAllowUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ThreadgateAllowUnion> {
        return when (val type = element.type()) {
            ThreadgateMentionRule.TYPE -> ThreadgateMentionRule.serializer()
            ThreadgateFollowingRule.TYPE -> ThreadgateFollowingRule.serializer()
            ThreadgateListRule.TYPE -> ThreadgateListRule.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ThreadgateAllowUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ThreadgateAllowUnion() {
        override var type: String = "unknown"
    }
}