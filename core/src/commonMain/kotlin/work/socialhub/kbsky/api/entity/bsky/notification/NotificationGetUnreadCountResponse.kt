package work.socialhub.kbsky.api.entity.bsky.notification

import kotlinx.serialization.Serializable

@Serializable
class NotificationGetUnreadCountResponse {
    var count: Int = -1
}
