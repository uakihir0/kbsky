package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.convo.ChatConvoDefsDeletedMessageView
import work.socialhub.kbsky.model.chat.bsky.convo.ChatConvoDefsMessageUnion
import work.socialhub.kbsky.model.chat.bsky.convo.ChatConvoDefsMessageView
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatConvoDefsMessageUnionSerializer :
    JsonContentPolymorphicSerializer<ChatConvoDefsMessageUnion>(
        ChatConvoDefsMessageUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ChatConvoDefsMessageUnion> {
        return when (val type = element.type()) {
            ChatConvoDefsMessageView.TYPE -> ChatConvoDefsMessageView.serializer()
            ChatConvoDefsDeletedMessageView.TYPE -> ChatConvoDefsDeletedMessageView.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatConvoDefsMessageUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ChatConvoDefsMessageUnion() {
        override var type: String = "unknown"
    }
}