package kbsky.bsky.graph

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.graph.GraphGetFollowersRequest
import work.socialhub.kbsky.domain.Service
import kotlin.test.Test

class GetFollowersTest : AbstractTest() {

    @Test
    fun testGetFollowers() {
        val response = BlueskyFactory
            .instance(Service.BSKY_SOCIAL.uri)
            .graph()
            .getFollowers(
                GraphGetFollowersRequest(accessJwt).also {
                    it.actor = "uakihir0.bsky.social"
                }
            )

        checkNotNull(response.data.followers)
            .forEach { print(it) }
    }
}
