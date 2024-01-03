package work.socialhub.kbsky.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.graph.GraphGetFollowsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetFollowsTest : AbstractTest() {

    @Test
    fun testGetFollows() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .graph()
            .getFollows(
                GraphGetFollowsRequest(accessJwt).also {
                    it.actor = "uakihir0.com"
                }
            )

        response.data.follows
            .forEach { print(it) }
    }
}
