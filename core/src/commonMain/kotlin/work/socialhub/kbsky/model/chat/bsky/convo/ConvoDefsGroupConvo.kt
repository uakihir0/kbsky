package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import work.socialhub.kbsky.model.chat.bsky.group.GroupDefsJoinLinkView
import kotlin.js.JsExport

/**
 * chat.bsky.convo.defs#groupConvo
 */
@Serializable
@JsExport
data class ConvoDefsGroupConvo(
    @SerialName("\$type")
    override val type: String = TYPE,
    val createdAt: String,
    // chat.bsky.convo.defs#convoLockStatus ("unlocked" / "locked" / "locked-permanently")
    val lockStatus: String,
    // Whether the lock was forced by moderation
    val lockStatusModerationOverride: Boolean,
    val memberCount: Int,
    val memberLimit: Int,
    val name: String,
    val joinLink: GroupDefsJoinLinkView? = null,
    // The following are available only to the owner
    val joinRequestCount: Int? = null,
    val unreadJoinRequestCount: Int? = null,
) : ConvoDefsConvoKindUnion() {

    companion object {
        const val TYPE = BlueskyTypes.ConvoDefs + "#groupConvo"
    }
}
