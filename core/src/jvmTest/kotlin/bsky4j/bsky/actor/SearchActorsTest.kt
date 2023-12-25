package kbsky.bsky.actor

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.actor.ActorSearchActorsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class SearchActorsTest : AbstractTest() {

    @Test
    fun testSearchActors() {
        val actors = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .actor()
            .searchActors(
                ActorSearchActorsRequest(accessJwt).also {
                    it.term = "uakihir0"
                }
            )

        checkNotNull(actors.data.actors)
            .forEach { print(it) }
    }
}
