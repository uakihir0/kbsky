package work.socialhub.kbsky.model.chat.bsky.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.actor.defs#pastGroupConvoMember
 *
 * Member who used to belong to the group (no fields)
 */
@Serializable
@JsExport
data class ActorDefsPastGroupConvoMember(
    @SerialName("\$type")
    override val type: String = TYPE,
) : ActorDefsProfileViewBasicKindUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ChatActorDefs + "#pastGroupConvoMember"
    }
}
