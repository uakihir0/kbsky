package work.socialhub.kbsky.api.entity.chat.bsky.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ConvoDeleteMessageForSelfRequest(
    accessJwt: String,
) : AuthRequest(accessJwt), MapRequest {

    lateinit var convoId: String
    lateinit var messageId: String

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("convoId", convoId)
            it.addParam("messageId", messageId)
        }
    }
}
