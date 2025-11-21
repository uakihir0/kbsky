package work.socialhub.kbsky.app.bsky.graph

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphBlockRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteBlockRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class BlockTest : AbstractTest() {

    @Test
    fun testBlock() {
        val did = "did:plc:oc6vwdlmk2kqyida5i74d3p5"

        // Block
        val response =client()
            .graph()
            .block(
                GraphBlockRequest(auth()).also {
                    it.subject = did
                }
            )

        val uri = checkNotNull(response.data.uri)

        client()
            .graph()
            .deleteBlock(
                GraphDeleteBlockRequest(auth()).also {
                    it.uri = uri
                }
            )
    }
}
