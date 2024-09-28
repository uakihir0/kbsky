package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsReasonPin
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsReasonRepost
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsReasonUnion
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object FeedDefsReasonPolymorphicSerializer :
    JsonContentPolymorphicSerializer<FeedDefsReasonUnion>(
        FeedDefsReasonUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<FeedDefsReasonUnion> {
        return when (val type = element.type()) {
            FeedDefsReasonRepost.TYPE -> FeedDefsReasonRepost.serializer()
            FeedDefsReasonPin.TYPE -> FeedDefsReasonPin.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (FeedDefsReasonUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : FeedDefsReasonUnion() {
        override var type: String = "unknown"
    }
}