package work.socialhub.kbsky.internal.app.bsky

import work.socialhub.kbsky.BlueskyConfig
import work.socialhub.kbsky.BlueskyTypes.NotificationGetUnreadCount
import work.socialhub.kbsky.BlueskyTypes.NotificationListNotifications
import work.socialhub.kbsky.BlueskyTypes.NotificationUpdateSeen
import work.socialhub.kbsky.api.app.bsky.NotificationResource
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationGetUnreadCountRequest
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationGetUnreadCountResponse
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationListNotificationsRequest
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationListNotificationsResponse
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationUpdateSeenRequest
import work.socialhub.kbsky.api.entity.share.Response
import work.socialhub.kbsky.internal.share._InternalUtility.getWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.httpRequest
import work.socialhub.kbsky.internal.share._InternalUtility.postWithAuth
import work.socialhub.kbsky.internal.share._InternalUtility.proceed
import work.socialhub.kbsky.internal.share._InternalUtility.proceedUnit
import work.socialhub.kbsky.internal.share._InternalUtility.xrpc
import work.socialhub.kbsky.util.MediaType
import work.socialhub.kbsky.util.toBlocking

class _NotificationResource(
    private val config: BlueskyConfig
) : NotificationResource {

    override suspend fun getUnreadCount(
        request: NotificationGetUnreadCountRequest
    ): Response<NotificationGetUnreadCountResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, NotificationGetUnreadCount))
                .accept(MediaType.JSON)
                .getWithAuth(request.auth)
        }
    }

    override fun getUnreadCountBlocking(
        request: NotificationGetUnreadCountRequest
    ): Response<NotificationGetUnreadCountResponse> = toBlocking { getUnreadCount(request) }

    override suspend fun listNotifications(
        request: NotificationListNotificationsRequest
    ): Response<NotificationListNotificationsResponse> {

        return proceed {
            httpRequest(config)
                .url(xrpc(config, NotificationListNotifications))
                .accept(MediaType.JSON)
                .queries(request.toMap())
                .getWithAuth(request.auth)
        }
    }

    override fun listNotificationsBlocking(
        request: NotificationListNotificationsRequest
    ): Response<NotificationListNotificationsResponse> = toBlocking { listNotifications(request) }

    override suspend fun updateSeen(
        request: NotificationUpdateSeenRequest
    ): Response<Unit> {

        return proceedUnit {
            httpRequest(config)
                .url(xrpc(config, NotificationUpdateSeen))
                .accept(MediaType.JSON)
                .json(request.toMappedJson())
                .postWithAuth(request.auth)
        }
    }

    override fun updateSeenBlocking(
        request: NotificationUpdateSeenRequest
    ): Response<Unit> = toBlocking { updateSeen(request) }
}
