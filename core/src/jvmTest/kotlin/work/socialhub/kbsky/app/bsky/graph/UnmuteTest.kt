package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphUnmuteActorRequest
import kotlin.test.Test

class UnmuteTest : AbstractTest() {

    @Test
    fun testUnmute() = runTest {
        client()
            .graph()
            .unmuteActor(
                GraphUnmuteActorRequest(auth()).also {
                    it.actor = "bsky.app"
                }
            )
    }
}
