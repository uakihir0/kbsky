package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsBookmarkItemUnion
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsNotFoundPost
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsPostView
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object FeedDefsBookmarkPolymorphicSerializer :
    JsonContentPolymorphicSerializer<FeedDefsBookmarkItemUnion>(
        FeedDefsBookmarkItemUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<FeedDefsBookmarkItemUnion> = when (val type = element.type()) {
        FeedDefsPostView.TYPE -> FeedDefsPostView.serializer()
        FeedDefsNotFoundPost.TYPE -> FeedDefsNotFoundPost.serializer()
        // TODO FeedDefsBlockedPost support
        else -> {
            println("[Warning] Unknown Item type: $type (FeedDefsBookmarkItemUnion)")
            Unknown.serializer()
        }
    }

    @Serializable
    class Unknown : FeedDefsBookmarkItemUnion {
        override var type: String = "unknown"
    }
}