package work.socialhub.kbsky.api.entity.app.bsky.notification


import work.socialhub.kbsky.api.entity.share.AuthRequest
import work.socialhub.kbsky.api.entity.share.MapRequest
import work.socialhub.kbsky.auth.AuthProvider
import kotlin.js.JsExport

@JsExport
data class NotificationListNotificationsRequest(
    override val auth: AuthProvider,
    var limit: Int? = null,
    var cursor: String? = null,
    /**
     * Notification reasons to filter by (e.g. "reply", "quote", "mention", "follow").
     * Array parameter: it must be expanded as `reasons=v1&reasons=v2` on the query string,
     * so it is kept out of [toMap] (khttpclient's `queries(Map)` calls `toString()`
     * on List values, producing `"[v1, v2]"`).
     */
    var reasons: List<String>? = null,
) : AuthRequest(auth), MapRequest {

    override fun toMap(): Map<String, Any> {
        return mutableMapOf<String, Any>().also {
            it.addParam("limit", limit)
            it.addParam("cursor", cursor)
        }
    }
}
