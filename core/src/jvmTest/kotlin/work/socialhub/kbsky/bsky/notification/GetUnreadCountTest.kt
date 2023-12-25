package work.socialhub.kbsky.bsky.notification

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.notification.NotificationGetUnreadCountRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetUnreadCountTest : AbstractTest() {

    @Test
    fun testGetUnreadCount() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .notification()
            .getUnreadCount(
                NotificationGetUnreadCountRequest(accessJwt)
            )

        println(response.data.count)
    }
}
