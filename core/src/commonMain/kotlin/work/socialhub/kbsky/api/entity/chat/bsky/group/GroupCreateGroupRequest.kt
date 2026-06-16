package work.socialhub.kbsky.api.entity.chat.bsky.group


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class GroupCreateGroupRequest(
    override val auth: AuthProvider,
    var members: List<String> = emptyList(),
    var name: String = "",
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("members", members)
            it.addParam("name", name)
        }
    }
}
