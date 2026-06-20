package work.socialhub.kbsky.api.entity.chat.bsky.group


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class GroupEditJoinLinkRequest(
    override val auth: AuthProvider,
    var convoId: String = "",
    var requireApproval: Boolean? = null,
    var joinRule: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("convoId", convoId)
            it.addParam("requireApproval", requireApproval)
            it.addParam("joinRule", joinRule)
        }
    }
}
