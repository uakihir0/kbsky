package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetBlocksRequest
import kotlin.test.Test

class GetBlocksTest : AbstractTest() {

    @Test
    fun testGetBlocks() = runTest {
        val response = client()
            .graph()
            .getBlocks(
                GraphGetBlocksRequest(auth())
            )

        response.data.blocks
            .forEach { print(it) }
    }
}
