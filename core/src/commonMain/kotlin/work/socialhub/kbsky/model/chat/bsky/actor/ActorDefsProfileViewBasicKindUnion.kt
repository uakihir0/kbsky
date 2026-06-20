package work.socialhub.kbsky.model.chat.bsky.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatActorDefsProfileViewBasicKindUnionSerializer
import kotlin.js.JsExport

/**
 * The kind field of chat.bsky.actor.defs#profileViewBasic
 *
 * @see ActorDefsDirectConvoMember
 * @see ActorDefsGroupConvoMember
 * @see ActorDefsPastGroupConvoMember
 */
@Serializable(with = ChatActorDefsProfileViewBasicKindUnionSerializer::class)
@JsExport
abstract class ActorDefsProfileViewBasicKindUnion {
    @SerialName("\$type")
    abstract val type: String

    val asDirectConvoMember get() = this as? ActorDefsDirectConvoMember
    val asGroupConvoMember get() = this as? ActorDefsGroupConvoMember
    val asPastGroupConvoMember get() = this as? ActorDefsPastGroupConvoMember
}
