package work.socialhub.kbsky.api.entity.chat.bsky.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

data class ConvoMuteConvoRequest(
    override val auth: AuthProvider,
    var convoId: String = "",
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("convoId", convoId)
        }
    }
}
