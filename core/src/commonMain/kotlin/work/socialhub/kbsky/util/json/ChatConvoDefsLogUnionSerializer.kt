package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.convo.*
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatConvoDefsLogUnionSerializer :
    JsonContentPolymorphicSerializer<ChatConvoDefsLogUnion>(
        ChatConvoDefsLogUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ChatConvoDefsLogUnion> {
        return when (val type = element.type()) {
            ChatConvoDefsLogBeginConvo.TYPE -> ChatConvoDefsLogBeginConvo.serializer()
            ChatConvoDefsLogLeaveConvo.TYPE -> ChatConvoDefsLogLeaveConvo.serializer()
            ChatConvoDefsLogCreateMessage.TYPE -> ChatConvoDefsLogCreateMessage.serializer()
            ChatConvoDefsLogDeleteMessage.TYPE -> ChatConvoDefsLogDeleteMessage.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatConvoDefsLogUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ChatConvoDefsLogUnion() {
        override var type: String = "unknown"
    }
}