package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetFollowsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetFollowsTest : AbstractTest() {

    @Test
    fun testGetFollows() {
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
