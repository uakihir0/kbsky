package work.socialhub.kbsky.model.chat.bsky.group


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import work.socialhub.kbsky.BlueskyTypes
import kotlin.js.JsExport

/**
 * chat.bsky.group.defs#invalidJoinLinkPreviewView
 *
 * For a non-existent code (code only)
 */
@Serializable
@JsExport
data class GroupDefsInvalidJoinLinkPreviewView(
    @SerialName("\$type")
    override val type: String = TYPE,
    val code: String,
) : GroupDefsJoinLinkPreviewUnion() {

    companion object {
        const val TYPE = BlueskyTypes.GroupDefs + "#invalidJoinLinkPreviewView"
    }
}
