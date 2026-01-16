package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowersRequest
import kotlin.test.Test

class GetFollowersTest : AbstractTest() {

    @Test
    fun testGetFollowers() = runTest {
        val response = client()
            .graph()
            .getFollowers(
                GraphGetFollowersRequest(auth()).also {
                    it.actor = "uakihir0.com"
                }
            )

        response.data.followers
            .forEach { print(it) }
    }
}
