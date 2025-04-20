package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogAddReaction
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogBeginConvo
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogCreateMessage
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogDeleteMessage
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogLeaveConvo
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogReadMessage
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogRemoveReaction
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsLogUnion
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatConvoDefsLogUnionSerializer :
    JsonContentPolymorphicSerializer<ConvoDefsLogUnion>(
        ConvoDefsLogUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ConvoDefsLogUnion> {
        return when (val type = element.type()) {
            ConvoDefsLogBeginConvo.TYPE -> ConvoDefsLogBeginConvo.serializer()
            ConvoDefsLogLeaveConvo.TYPE -> ConvoDefsLogLeaveConvo.serializer()
            ConvoDefsLogCreateMessage.TYPE -> ConvoDefsLogCreateMessage.serializer()
            ConvoDefsLogDeleteMessage.TYPE -> ConvoDefsLogDeleteMessage.serializer()
            ConvoDefsLogReadMessage.TYPE -> ConvoDefsLogReadMessage.serializer()
            ConvoDefsLogAddReaction.TYPE -> ConvoDefsLogAddReaction.serializer()
            ConvoDefsLogRemoveReaction.TYPE -> ConvoDefsLogRemoveReaction.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatConvoDefsLogUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ConvoDefsLogUnion() {
        override var type: String = "unknown"
    }
}