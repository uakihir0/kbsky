package work.socialhub.kbsky.api.entity.app.bsky.notification


import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.notification.NotificationListNotificationsNotification
import kotlin.js.JsExport

@Serializable
@JsExport
data class NotificationListNotificationsResponse(
    var cursor: String? = null,
    var notifications: List<NotificationListNotificationsNotification> = emptyList(),
)
