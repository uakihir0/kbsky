package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphUnmuteActorRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class UnmuteTest : AbstractTest() {

    @Test
    fun testUnmute() {
        BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .graph()
            .unmuteActor(
                GraphUnmuteActorRequest(auth()).also {
                    it.actor = "bsky.app"
                }
            )
    }
}
