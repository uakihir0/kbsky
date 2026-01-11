package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphMuteActorRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class MuteTest : AbstractTest() {

    @Test
    fun testMute() = runTest {
        client()
            .graph()
            .muteActor(
                GraphMuteActorRequest(auth()).also {
                    it.actor = "bsky.app"
                }
            )
    }

    @Test
    fun testMuteByDID() = runTest {
        client()
            .graph()
            .muteActor(
                GraphMuteActorRequest(auth()).also {
                    it.actor = "did:plc:oc6vwdlmk2kqyida5i74d3p5"
                }
            )
    }
}
