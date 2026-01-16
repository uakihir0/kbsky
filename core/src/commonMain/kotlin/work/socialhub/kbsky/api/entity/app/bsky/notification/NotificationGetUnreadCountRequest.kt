package work.socialhub.kbsky.api.entity.app.bsky.notification


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class NotificationGetUnreadCountRequest(
    override val auth: AuthProvider,
) : AuthRequest(auth)
