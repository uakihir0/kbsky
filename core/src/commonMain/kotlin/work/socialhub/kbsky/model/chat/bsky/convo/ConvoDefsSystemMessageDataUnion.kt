package work.socialhub.kbsky.model.chat.bsky.convo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatConvoDefsSystemMessageDataUnionSerializer
import kotlin.js.JsExport

/**
 * The data field of chat.bsky.convo.defs#systemMessageView (12 variants)
 */
@Serializable(with = ChatConvoDefsSystemMessageDataUnionSerializer::class)
@JsExport
abstract class ConvoDefsSystemMessageDataUnion {
    @SerialName("\$type")
    abstract val type: String

    val asAddMember get() = this as? ConvoDefsSystemMessageDataAddMember
    val asRemoveMember get() = this as? ConvoDefsSystemMessageDataRemoveMember
    val asMemberJoin get() = this as? ConvoDefsSystemMessageDataMemberJoin
    val asMemberLeave get() = this as? ConvoDefsSystemMessageDataMemberLeave
    val asLockConvo get() = this as? ConvoDefsSystemMessageDataLockConvo
    val asUnlockConvo get() = this as? ConvoDefsSystemMessageDataUnlockConvo
    val asLockConvoPermanently get() = this as? ConvoDefsSystemMessageDataLockConvoPermanently
    val asEditGroup get() = this as? ConvoDefsSystemMessageDataEditGroup
    val asCreateJoinLink get() = this as? ConvoDefsSystemMessageDataCreateJoinLink
    val asEditJoinLink get() = this as? ConvoDefsSystemMessageDataEditJoinLink
    val asEnableJoinLink get() = this as? ConvoDefsSystemMessageDataEnableJoinLink
    val asDisableJoinLink get() = this as? ConvoDefsSystemMessageDataDisableJoinLink
}
