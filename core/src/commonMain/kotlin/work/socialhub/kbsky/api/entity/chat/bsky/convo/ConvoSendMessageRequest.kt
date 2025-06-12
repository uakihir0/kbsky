package work.socialhub.kbsky.api.entity.chat.bsky.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.model.chat.bsky.convo.ConvoDefsMessageInput

data class ConvoSendMessageRequest(
    override val auth: AuthProvider,
    var convoId: String = "",
    var message: ConvoDefsMessageInput? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("convoId", convoId)
            it.addParam("message", message)
        }
    }
}
