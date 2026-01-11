package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphGetMutesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetMutesTest : AbstractTest() {

    @Test
    fun testGetMutes() = runTest {
        val response = client()
            .graph()
            .getMutes(
                GraphGetMutesRequest(auth())
            )

        response.data.mutes.forEach {
            dump(it)
        }
    }
}
