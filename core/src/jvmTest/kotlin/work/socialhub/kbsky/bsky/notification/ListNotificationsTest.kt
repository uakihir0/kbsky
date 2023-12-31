package work.socialhub.kbsky.bsky.notification

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.notification.NotificationListNotificationsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class ListNotificationsTest : AbstractTest() {

    @Test
    fun testListNotifications() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .notification()
            .listNotifications(
                NotificationListNotificationsRequest(accessJwt)
            )

        response.data.notifications.forEach {
            println("|NOTIFICATION|-----------------------------------------")
            println("REASON> " + it.reason)
            print(it.record)
        }
    }
}
