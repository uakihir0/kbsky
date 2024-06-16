package work.socialhub.kbsky.api.entity.chat.bsky.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class ConvoGetConvoRequest (
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mapOf()
    }
}
