package work.socialhub.kbsky.api.entity.bsky.notification

import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest

class NotificationUpdateSeenRequest internal constructor(
    accessJwt: String
) : AuthRequest(accessJwt), MapRequest {

    var seenAt: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("seenAt", seenAt)
        }
    }

    fun seenAt(): String {
        return seenAt ?: TODO("seenAt is not set")
    }
}
