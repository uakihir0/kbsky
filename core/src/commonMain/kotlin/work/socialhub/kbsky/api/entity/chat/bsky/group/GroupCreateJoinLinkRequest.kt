package work.socialhub.kbsky.api.entity.chat.bsky.group


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class GroupCreateJoinLinkRequest(
    override val auth: AuthProvider,
    var convoId: String = "",
    var joinRule: String = "",
    var requireApproval: Boolean? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("convoId", convoId)
            it.addParam("joinRule", joinRule)
            it.addParam("requireApproval", requireApproval)
        }
    }
}
