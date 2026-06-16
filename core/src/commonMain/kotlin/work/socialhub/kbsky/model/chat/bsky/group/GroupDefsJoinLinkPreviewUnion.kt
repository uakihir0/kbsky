package work.socialhub.kbsky.model.chat.bsky.group


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.util.json.ChatGroupDefsJoinLinkPreviewUnionSerializer
import kotlin.js.JsExport

/**
 * @see GroupDefsJoinLinkPreviewView
 * @see GroupDefsDisabledJoinLinkPreviewView
 * @see GroupDefsInvalidJoinLinkPreviewView
 */
@Serializable(with = ChatGroupDefsJoinLinkPreviewUnionSerializer::class)
@JsExport
abstract class GroupDefsJoinLinkPreviewUnion {
    @SerialName("\$type")
    abstract val type: String

    val asJoinLinkPreviewView get() = this as? GroupDefsJoinLinkPreviewView
    val asDisabledJoinLinkPreviewView get() = this as? GroupDefsDisabledJoinLinkPreviewView
    val asInvalidJoinLinkPreviewView get() = this as? GroupDefsInvalidJoinLinkPreviewView
}
