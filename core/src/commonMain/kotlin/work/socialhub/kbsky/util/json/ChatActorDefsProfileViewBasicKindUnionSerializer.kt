package work.socialhub.kbsky.util.json

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsDirectConvoMember
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsGroupConvoMember
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsPastGroupConvoMember
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasicKindUnion
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ChatActorDefsProfileViewBasicKindUnionSerializer :
    JsonContentPolymorphicSerializer<ActorDefsProfileViewBasicKindUnion>(
        ActorDefsProfileViewBasicKindUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ActorDefsProfileViewBasicKindUnion> {
        return when (val type = element.type()) {
            ActorDefsDirectConvoMember.TYPE -> ActorDefsDirectConvoMember.serializer()
            ActorDefsGroupConvoMember.TYPE -> ActorDefsGroupConvoMember.serializer()
            ActorDefsPastGroupConvoMember.TYPE -> ActorDefsPastGroupConvoMember.serializer()
            else -> {
                println("[Warning] Unknown Item type: $type (ChatActorDefsProfileViewBasicKindUnion)")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ActorDefsProfileViewBasicKindUnion() {
        override var type: String = "unknown"
    }
}
