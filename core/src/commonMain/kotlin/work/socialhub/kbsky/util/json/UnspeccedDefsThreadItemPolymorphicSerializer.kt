package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemBlocked
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemNoUnauthenticated
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemNotFound
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemPost
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemUnion
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object UnspeccedDefsThreadItemPolymorphicSerializer :
    JsonContentPolymorphicSerializer<UnspeccedDefsThreadItemUnion>(
        UnspeccedDefsThreadItemUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<UnspeccedDefsThreadItemUnion> {
        return when (val type = element.type()) {
            UnspeccedDefsThreadItemPost.TYPE -> UnspeccedDefsThreadItemPost.serializer()
            UnspeccedDefsThreadItemNoUnauthenticated.TYPE -> UnspeccedDefsThreadItemNoUnauthenticated.serializer()
            UnspeccedDefsThreadItemNotFound.TYPE -> UnspeccedDefsThreadItemNotFound.serializer()
            UnspeccedDefsThreadItemBlocked.TYPE -> UnspeccedDefsThreadItemBlocked.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (UnspeccedDefsThreadItemUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : UnspeccedDefsThreadItemUnion() {
        override var type: String = "unknown"
    }
}
