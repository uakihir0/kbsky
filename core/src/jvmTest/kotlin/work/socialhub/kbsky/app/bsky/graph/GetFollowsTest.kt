package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowsRequest
import kotlin.test.Test

class GetFollowsTest : AbstractTest() {

    @Test
    fun testGetFollows() = runTest {
        val response = client()
            .graph()
            .getFollows(
                GraphGetFollowsRequest(auth()).also {
                    it.actor = "uakihir0.com"
                }
            )

        response.data.follows
            .forEach { print(it) }
    }
}
