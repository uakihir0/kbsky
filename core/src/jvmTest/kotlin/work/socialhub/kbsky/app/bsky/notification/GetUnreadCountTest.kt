package work.socialhub.kbsky.app.bsky.notification

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationGetUnreadCountRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetUnreadCountTest : AbstractTest() {

    @Test
    fun testGetUnreadCount() = runTest {
        val response = client()
            .notification()
            .getUnreadCount(
                NotificationGetUnreadCountRequest(auth())
            )

        println(response.data.count)
    }
}
