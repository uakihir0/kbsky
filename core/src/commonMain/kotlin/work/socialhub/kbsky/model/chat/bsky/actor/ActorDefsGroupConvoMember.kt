package work.socialhub.kbsky.model.chat.bsky.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.actor.defs#groupConvoMember
 */
@Serializable
@JsExport
data class ActorDefsGroupConvoMember(
    @SerialName("\$type")
    override val type: String = TYPE,
    // chat.bsky.actor.defs#memberRole ("owner" / "standard")
    val role: String,
    // Only when the member was added rather than joining via a link
    val addedBy: ActorDefsProfileViewBasic? = null,
) : ActorDefsProfileViewBasicKindUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ChatActorDefs + "#groupConvoMember"
    }
}
