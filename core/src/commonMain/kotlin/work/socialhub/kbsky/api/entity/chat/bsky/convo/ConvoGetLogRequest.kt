package work.socialhub.kbsky.api.entity.chat.bsky.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

class ConvoGetLogRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    lateinit var cursor: String

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("cursor", cursor)
        }
    }
}
