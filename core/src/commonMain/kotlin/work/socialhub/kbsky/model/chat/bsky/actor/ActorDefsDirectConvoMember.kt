package work.socialhub.kbsky.model.chat.bsky.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.actor.defs#directConvoMember
 *
 * Member of a 1-on-1 direct message (no fields)
 */
@Serializable
@JsExport
data class ActorDefsDirectConvoMember(
    @SerialName("\$type")
    override val type: String = TYPE,
) : ActorDefsProfileViewBasicKindUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ChatActorDefs + "#directConvoMember"
    }
}
