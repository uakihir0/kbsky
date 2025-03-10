package work.socialhub.kbsky.api.entity.app.bsky.notification

import kotlinx.serialization.Serializable

@Serializable
data class NotificationGetUnreadCountResponse(
    var count: Int = -1
)
