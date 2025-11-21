package work.socialhub.kbsky.api.entity.app.bsky.notification

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import work.socialhub.kbsky.internal.share._InternalUtility

data class NotificationUpdateSeenRequest(
    override val auth: AuthProvider,
    var seenAt: String? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("seenAt", seenAt())
        }
    }

    @OptIn(ExperimentalTime::class)
    fun seenAt(): String {
        return seenAt ?: _InternalUtility.dateFormat.format(Clock.System.now())
    }
}
