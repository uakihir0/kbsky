package work.socialhub.kbsky.api.entity.chat.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ChatConvoGetConvoForMembersRequest(
    accessJwt: String,
) : AuthRequest(accessJwt), MapRequest {

    // did
    lateinit var members: List<String>

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            // the API seems to be support one member only in 2024/06/25
            it.addParam("members", members.first())
        }
    }
}
