package work.socialhub.kbsky.app.bsky.notification

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.notification.NotificationUpdateSeenRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class UpdateSeenTest : AbstractTest() {

    @Test
    fun testUpdateSeen() = runTest {
        client()
            .notification()
            .updateSeen(
                NotificationUpdateSeenRequest(auth())
            )
    }
}
