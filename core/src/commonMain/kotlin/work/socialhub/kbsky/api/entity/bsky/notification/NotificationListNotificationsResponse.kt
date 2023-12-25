package work.socialhub.kbsky.api.entity.bsky.notification

import kotlinx.serialization.Serializable
import work.socialhub.kbsky.model.bsky.notification.NotificationListNotificationsNotification

@Serializable
class NotificationListNotificationsResponse {
    var cursor: String? = null
    var notifications: List<NotificationListNotificationsNotification>? = null
}
