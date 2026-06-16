package work.socialhub.kbsky.model.chat.bsky.group


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.chat.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsConvoView
import kotlin.js.JsExport

/**
 * chat.bsky.group.defs#joinLinkPreviewView
 */
@Serializable
@JsExport
data class GroupDefsJoinLinkPreviewView(
    @SerialName("\$type")
    override val type: String = TYPE,
    val convoId: String,
    val code: String,
    val name: String,
    val owner: ActorDefsProfileViewBasic,
    val memberCount: Int,
    val memberLimit: Int,
    val requireApproval: Boolean,
    // chat.bsky.group.defs#joinRule ("anyone" / "followedByOwner")
    val joinRule: String,
    // Only when authenticated and a member
    val convo: ConvoDefsConvoView? = null,
    val viewer: GroupDefsJoinLinkViewerState? = null,
) : GroupDefsJoinLinkPreviewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GroupDefs + "#joinLinkPreviewView"
    }
}
