package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPackRequest
import kotlin.test.Test

class GetGraphStarterPackTest : AbstractTest() {

    @Test
    fun testGetStarterPack() = runTest {
        val response = client()
            .graph()
            .getStarterPack(
                GraphGetStarterPackRequest(auth()).also {
                    it.starterPack = "at://did:plc:xpu5e52rhk6a3efljymgnmz4/app.bsky.graph.list/3lbpq5dooda2k"
                }
            )

        println("Name: ${response.data.starterPack.record.asGraphStarterPack?.name}")
    }
}
