package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteFollowRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphFollowRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class FollowTest : AbstractTest() {

    @Test
    fun testFollow() = runTest {
        val did = "did:plc:oc6vwdlmk2kqyida5i74d3p5"

        // Follow
        val response = client()
            .graph()
            .follow(
                GraphFollowRequest(auth()).also {
                    it.subject = did
                }
            )

        val uri = checkNotNull(response.data.uri)
        println(uri)

        // DeleteFollow
        client()
            .graph()
            .deleteFollow(
                GraphDeleteFollowRequest(auth()).also {
                    it.uri = uri
                }
            )
    }
}
