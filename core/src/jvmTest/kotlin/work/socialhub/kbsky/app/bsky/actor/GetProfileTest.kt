package work.socialhub.kbsky.app.bsky.actor

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfileRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetProfileTest : AbstractTest() {

    @Test
    fun testGetProfile() = runTest {
        val actor = client()
            .actor()
            .getProfile(
                ActorGetProfileRequest(auth()).also {
                    it.actor = "uakihir0.com"
                }
            )

        print(actor.data)
    }
}
