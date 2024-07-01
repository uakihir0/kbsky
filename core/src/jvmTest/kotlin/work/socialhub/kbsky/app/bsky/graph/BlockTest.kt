package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphBlockRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteBlockRequest
import work.socialhub.kbsky.domain.Service
import kotlin.test.Test

class BlockTest : AbstractTest() {

    @Test
    fun testBlock() {
        val did = "did:plc:oc6vwdlmk2kqyida5i74d3p5"

        // Block
        val response = BlueskyFactory
            .instance(Service.BSKY_SOCIAL.uri)
            .graph()
            .block(
                GraphBlockRequest(accessJwt).also {
                    it.subject = did
                }
            )

        val uri = checkNotNull(response.data.uri)

        BlueskyFactory
            .instance(Service.BSKY_SOCIAL.uri)
            .graph()
            .deleteBlock(
                GraphDeleteBlockRequest(accessJwt).also {
                    it.uri = uri
                }
            )
    }
}
