package work.socialhub.kbsky.model.com.atproto.moderation

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import work.socialhub.kbsky.model.com.atproto.repo.RepoRef
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.util.json.JsonElementUtil.type

object ModerationSubjectUnionSerializer :
    JsonContentPolymorphicSerializer<ModerationSubjectUnion>(
        ModerationSubjectUnion::class
    ) {

    override fun selectDeserializer(
        element: JsonElement
    ): DeserializationStrategy<ModerationSubjectUnion> {
        return when (val type = element.type()) {
            "com.atproto.admin.defs#repoRef" -> RepoRef.serializer()
            "com.atproto.repo.strongRef" -> RepoStrongRef.serializer()
            else -> {
                println("[Warning] Unknown ModerationSubjectUnion type: $type")
                Unknown.serializer()
            }
        }
    }

    @Serializable
    class Unknown : ModerationSubjectUnion() {
        override val type: String = "unknown"
        override fun toMap(): Map<String, Any> = mapOf("\$type" to type)
    }
}