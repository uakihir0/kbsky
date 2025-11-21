package work.socialhub.kbsky.app.bsky.actor

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorSearchActorsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class SearchActorsTest : AbstractTest() {

    @Test
    fun testSearchActors() {
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
