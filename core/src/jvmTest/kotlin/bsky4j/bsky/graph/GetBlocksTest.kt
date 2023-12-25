package kbsky.bsky.graph

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.graph.GraphGetBlocksRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetBlocksTest : AbstractTest() {

    @Test
    fun testGetBlocks() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .graph()
            .getBlocks(
                GraphGetBlocksRequest(accessJwt)
            )

        checkNotNull(response.data.blocks)
            .forEach { print(it) }
    }
}
