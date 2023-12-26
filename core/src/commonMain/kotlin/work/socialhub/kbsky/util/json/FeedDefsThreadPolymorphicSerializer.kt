package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.feed.FeedDefsNotFoundPost
import work.socialhub.kbsky.model.bsky.feed.FeedDefsThreadUnion
import work.socialhub.kbsky.model.bsky.feed.FeedDefsThreadViewPost

object FeedDefsThreadPolymorphicSerializer :
    JsonContentPolymorphicSerializer<FeedDefsThreadUnion>(
        FeedDefsThreadUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<FeedDefsThreadUnion> {
        return when (element.jsonObject["\$type"]?.jsonPrimitive?.content) {
            FeedDefsThreadViewPost.TYPE -> FeedDefsThreadViewPost.serializer()
            FeedDefsNotFoundPost.TYPE -> FeedDefsNotFoundPost.serializer()
            else -> throw Exception("Unknown Item type")
        }
    }
}