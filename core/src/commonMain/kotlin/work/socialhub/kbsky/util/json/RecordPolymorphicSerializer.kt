package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.model.bsky.actor.ActorProfile
import work.socialhub.kbsky.model.bsky.feed.FeedLike
import work.socialhub.kbsky.model.bsky.feed.FeedPost
import work.socialhub.kbsky.model.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.bsky.graph.GraphBlock
import work.socialhub.kbsky.model.bsky.graph.GraphFollow
import work.socialhub.kbsky.model.share.RecordUnion

object RecordPolymorphicSerializer : JsonContentPolymorphicSerializer<RecordUnion>(
    RecordUnion::class
) {
    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<RecordUnion> {
        return when (element.jsonObject["\$type"]?.jsonPrimitive?.content) {
            ActorProfile.TYPE -> ActorProfile.serializer()
            GraphFollow.TYPE -> GraphFollow.serializer()
            GraphBlock.TYPE -> GraphBlock.serializer()
            FeedLike.TYPE -> FeedLike.serializer()
            FeedPost.TYPE -> FeedPost.serializer()
            FeedRepost.TYPE -> FeedPost.serializer()
            else -> throw Exception("Unknown Item type")
        }
    }
}