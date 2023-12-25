package kbsky.bsky.graph

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.graph.GraphMuteActorRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class MuteTest : AbstractTest() {

    @Test
    fun testMute() {
        BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .graph().muteActor(
                GraphMuteActorRequest(accessJwt).also {
                    it.actor = "uakihir0.bsky.social"
                }
            )
    }

    @Test
    fun testMuteByDID() {
        BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .graph().muteActor(
                GraphMuteActorRequest(accessJwt).also {
                    it.actor = "did:plc:oc6vwdlmk2kqyida5i74d3p5"
                }
            )
    }
}
