package work.socialhub.kbsky.api.entity.app.bsky.notification

import kotlinx.datetime.Clock
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.internal.share._InternalUtility

class NotificationUpdateSeenRequest(
    auth: AuthProvider
) : AuthRequest(auth), MapRequest {

    var seenAt: String? = null

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("seenAt", seenAt())
        }
    }

    fun seenAt(): String {
        return seenAt ?: _InternalUtility.dateFormat.format(Clock.System.now())
    }
}
