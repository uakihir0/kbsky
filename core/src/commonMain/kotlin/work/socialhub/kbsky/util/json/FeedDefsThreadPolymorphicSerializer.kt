package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsNotFoundPost
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadUnion
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsThreadViewPost
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object FeedDefsThreadPolymorphicSerializer :
    JsonContentPolymorphicSerializer<FeedDefsThreadUnion>(
        FeedDefsThreadUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<FeedDefsThreadUnion> {
        return when (val type = element.type()) {
            FeedDefsThreadViewPost.TYPE -> FeedDefsThreadViewPost.serializer()
            FeedDefsNotFoundPost.TYPE -> FeedDefsNotFoundPost.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (FeedDefsThreadUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : FeedDefsThreadUnion() {
        override var type: String = "unknown"
    }
}