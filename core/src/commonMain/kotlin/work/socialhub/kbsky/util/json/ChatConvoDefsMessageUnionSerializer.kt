package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsDeletedMessageView
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsMessageUnion
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsMessageView
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatConvoDefsMessageUnionSerializer :
    JsonContentPolymorphicSerializer<ConvoDefsMessageUnion>(
        ConvoDefsMessageUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ConvoDefsMessageUnion> {
        return when (val type = element.type()) {
            ConvoDefsMessageView.TYPE -> ConvoDefsMessageView.serializer()
            ConvoDefsDeletedMessageView.TYPE -> ConvoDefsDeletedMessageView.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatConvoDefsMessageUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ConvoDefsMessageUnion() {
        override var type: String = "unknown"
    }
}