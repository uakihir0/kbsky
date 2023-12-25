package kbsky.bsky.notification

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.notification.NotificationUpdateSeenRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class UpdateSeenTest : AbstractTest() {

    @Test
    fun testUpdateSeen() {
        BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .notification()
            .updateSeen(
                NotificationUpdateSeenRequest(accessJwt)
            )
    }
}
