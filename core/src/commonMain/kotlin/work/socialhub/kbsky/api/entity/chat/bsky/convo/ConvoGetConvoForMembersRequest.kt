package work.socialhub.kbsky.api.entity.chat.bsky.convo

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider

data class ConvoGetConvoForMembersRequest(
    override val auth: AuthProvider,
    var members: List<String> = emptyList(),
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            // the API seems to be support one member only in 2024/06/25
            it.addParam("members", members.first())
        }
    }
}
