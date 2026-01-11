package work.socialhub.kbsky.app.bsky.actor

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorGetProfilesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetProfilesTest : AbstractTest() {

    @Test
    fun testGetProfiles() = runTest {
        val handles = listOf(
            "why.bsky.team",
            "jay.bsky.team",
            "uakihir0.com"
        )

        val actors = client()
            .actor()
            .getProfiles(
                ActorGetProfilesRequest(auth()).also {
                    it.actors = handles
                }
            )

        actors.data.profiles.forEach { print(it) }
    }
}
