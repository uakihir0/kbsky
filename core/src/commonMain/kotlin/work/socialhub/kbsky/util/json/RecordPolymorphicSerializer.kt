package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.actor.ActorProfile
import work.socialhub.kbsky.model.app.bsky.feed.FeedLike
import work.socialhub.kbsky.model.app.bsky.feed.FeedPost
import work.socialhub.kbsky.model.app.bsky.feed.FeedPostgate
import work.socialhub.kbsky.model.app.bsky.feed.FeedRepost
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgate
import work.socialhub.kbsky.model.app.bsky.graph.GraphBlock
import work.socialhub.kbsky.model.app.bsky.graph.GraphFollow
import work.socialhub.kbsky.model.app.bsky.graph.GraphList
import work.socialhub.kbsky.model.app.bsky.graph.GraphListItem
import work.socialhub.kbsky.model.app.bsky.graph.GraphStarterPack
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
            GraphListItem.TYPE -> GraphListItem.serializer()
            GraphList.TYPE -> GraphList.serializer()
            FeedThreadgate.TYPE -> FeedThreadgate.serializer()
            FeedPostgate.TYPE -> FeedPostgate.serializer()
            GraphStarterPack.TYPE -> GraphStarterPack.serializer()

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