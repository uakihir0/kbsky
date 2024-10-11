package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteFollowRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphFollowRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class FollowTest : AbstractTest() {

    @Test
    fun testFollow() {
        val did = "did:plc:oc6vwdlmk2kqyida5i74d3p5"

        // Follow
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .graph().follow(
                GraphFollowRequest(auth()).also {
                    it.subject = did
                }
            )

        val uri = checkNotNull(response.data.uri)
        println(uri)

        // DeleteFollow
        BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .graph()
            .deleteFollow(
                GraphDeleteFollowRequest(auth()).also {
                    it.uri = uri
                }
            )
    }
}
