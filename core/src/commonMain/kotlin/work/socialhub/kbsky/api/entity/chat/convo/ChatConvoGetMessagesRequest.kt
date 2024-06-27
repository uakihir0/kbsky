package work.socialhub.kbsky.api.entity.chat.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ChatConvoGetMessagesRequest(
    accessJwt: String,
) : AuthRequest(accessJwt), MapRequest {

    lateinit var convoId: String
    var limit: Int? = null
    var cursor: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("convoId", convoId)
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
