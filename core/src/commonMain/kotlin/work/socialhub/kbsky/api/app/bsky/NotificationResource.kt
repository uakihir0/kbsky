package work.socialhub.kbsky.api.app.bsky


import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationGetUnreadCountRequest
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationGetUnreadCountResponse
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationListNotificationsRequest
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationListNotificationsResponse
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationUpdateSeenRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.api.entity.share.ResponseUnit
import kotlin.js.JsExport


/**
 * Bluesky/Notification
 * [Reference](https://atproto.com/lexicons/app-bsky-notification)
 */
@JsExport
interface NotificationResource {

    /**
     * Get the number of unread notifications.
     */
    suspend fun getUnreadCount(
        request: NotificationGetUnreadCountRequest
    ): Response<NotificationGetUnreadCountResponse>

    @JsExport.Ignore
    fun getUnreadCountBlocking(
        request: NotificationGetUnreadCountRequest
    ): Response<NotificationGetUnreadCountResponse>

    /**
     * List notifications.
     */
    suspend fun listNotifications(
        request: NotificationListNotificationsRequest
    ): Response<NotificationListNotificationsResponse>

    @JsExport.Ignore
    fun listNotificationsBlocking(
        request: NotificationListNotificationsRequest
    ): Response<NotificationListNotificationsResponse>

    /**
     * Notify server that the user has seen notifications.
     */
    suspend fun updateSeen(
        request: NotificationUpdateSeenRequest
    ): ResponseUnit

    @JsExport.Ignore
    fun updateSeenBlocking(
        request: NotificationUpdateSeenRequest
    ): ResponseUnit
}
