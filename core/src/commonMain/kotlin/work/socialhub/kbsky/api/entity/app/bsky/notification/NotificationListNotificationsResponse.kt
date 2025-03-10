package work.socialhub.kbsky.api.entity.app.bsky.notification

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.app.bsky.notification.NotificationListNotificationsNotification

@Serializable
data class NotificationListNotificationsResponse(
    var cursor: String? = null,
    var notifications: List<NotificationListNotificationsNotification>
)
