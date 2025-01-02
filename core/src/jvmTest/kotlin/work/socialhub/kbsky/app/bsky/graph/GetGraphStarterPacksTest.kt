package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetStarterPacksRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetGraphStarterPacksTest : AbstractTest() {

    val starterPacks = listOf(
        "at://did:plc:xpu5e52rhk6a3efljymgnmz4/app.bsky.graph.list/3lbpq5dooda2k"
    )

    @Test
    fun testGetStarterPacks() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
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
