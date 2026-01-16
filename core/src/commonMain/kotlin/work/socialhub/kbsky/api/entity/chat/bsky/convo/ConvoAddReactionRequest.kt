package work.socialhub.kbsky.api.entity.chat.bsky.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

@JsExport
data class ConvoAddReactionRequest(
    override val auth: AuthProvider,
    val convoId: String,
    val messageId: String,
    val value: String,
) : AuthRequest(auth), MapRequest {


    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("convoId", convoId)
            it.addParam("messageId", messageId)
            it.addParam("value", value)
        }
    }
}
