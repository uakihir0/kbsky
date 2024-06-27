package work.socialhub.kbsky.api.entity.chat.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ChatConvoGetLogRequest(
    accessJwt: String,
) : AuthRequest(accessJwt), MapRequest {

    lateinit var cursor: String

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("cursor", cursor)
        }
    }
}
