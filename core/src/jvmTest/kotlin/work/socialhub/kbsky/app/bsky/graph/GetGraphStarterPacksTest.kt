package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPacksRequest
import kotlin.test.Test

class GetGraphStarterPacksTest : AbstractTest() {

    val starterPacks = listOf(
        "at://did:plc:xpu5e52rhk6a3efljymgnmz4/app.bsky.graph.list/3lbpq5dooda2k"
    )

    @Test
    fun testGetStarterPacks() = runTest {
        val response = client()
            .graph()
            .getStarterPacks(
                GraphGetStarterPacksRequest(auth()).also {
                    it.uris = starterPacks
                }
            )

        response.data.starterPacks.forEach {
            println("Name: ${it.record.asGraphStarterPack?.name}")
        }
    }
}
