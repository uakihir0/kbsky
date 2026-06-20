package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsConvoKindUnion
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsDirectConvo
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsGroupConvo
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatConvoDefsConvoKindUnionSerializer :
    JsonContentPolymorphicSerializer<ConvoDefsConvoKindUnion>(
        ConvoDefsConvoKindUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ConvoDefsConvoKindUnion> {
        return when (val type = element.type()) {
            ConvoDefsGroupConvo.TYPE -> ConvoDefsGroupConvo.serializer()
            ConvoDefsDirectConvo.TYPE -> ConvoDefsDirectConvo.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatConvoDefsConvoKindUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ConvoDefsConvoKindUnion() {
        override var type: String = "unknown"
    }
}
