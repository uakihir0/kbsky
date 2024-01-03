package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.actor.ActorProfile
import work.socialhub.kbsky.model.bsky.feed.FeedDefsThreadUnion
import work.socialhub.kbsky.model.bsky.feed.FeedLike
import work.socialhub.kbsky.model.bsky.feed.FeedPost
import work.socialhub.kbsky.model.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.bsky.graph.GraphBlock
import work.socialhub.kbsky.model.bsky.graph.GraphFollow
import work.socialhub.kbsky.model.share.RecordUnion
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object RecordPolymorphicSerializer :
    JsonContentPolymorphicSerializer<RecordUnion>(
        RecordUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<RecordUnion> {
        return when (val type = element.type()) {
            ActorProfile.TYPE -> ActorProfile.serializer()
            GraphFollow.TYPE -> GraphFollow.serializer()
            GraphBlock.TYPE -> GraphBlock.serializer()
            FeedLike.TYPE -> FeedLike.serializer()
            FeedPost.TYPE -> FeedPost.serializer()
            FeedRepost.TYPE -> FeedRepost.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (RecordUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : RecordUnion() {
        override var type: String = "unknown"
    }
}