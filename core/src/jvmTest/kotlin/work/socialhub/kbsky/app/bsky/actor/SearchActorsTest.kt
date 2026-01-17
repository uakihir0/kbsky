package work.socialhub.kbsky.app.bsky.actor

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsRequest
import kotlin.test.Test

class SearchActorsTest : AbstractTest() {

    @Test
    fun testSearchActors() = runTest {
        val actors = client()
            .actor()
            .searchActors(
                ActorSearchActorsRequest(auth()).also {
                    it.q = "uakihir0"
                }
            )

        actors.data.actors.forEach { print(it) }
    }
}
