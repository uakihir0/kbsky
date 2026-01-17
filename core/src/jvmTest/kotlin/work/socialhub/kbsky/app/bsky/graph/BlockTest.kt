package work.socialhub.kbsky.app.bsky.graph

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphBlockRequest
import work.socialhub.kbsky.api.entity.app.bsky.graph.GraphDeleteBlockRequest
import kotlin.test.Test

class BlockTest : AbstractTest() {

    @Test
    fun testBlock() = runTest {
        val did = "did:plc:oc6vwdlmk2kqyida5i74d3p5"

        // Block
        val response = client()
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
