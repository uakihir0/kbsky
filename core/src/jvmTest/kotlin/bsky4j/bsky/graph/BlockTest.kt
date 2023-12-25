package kbsky.bsky.graph

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.graph.GraphBlockRequest
import work.socialhub.kbsky.api.entity.bsky.graph.GraphDeleteBlockRequest
import work.socialhub.kbsky.domain.Service
import kotlin.test.Test

class BlockTest : AbstractTest() {

    @Test
    fun testBlock() {
        val did = "did:plc:oc6vwdlmk2kqyida5i74d3p5"
        var uri: String

        run {
            // Block
            val response = BlueskyFactory
                .instance(Service.BSKY_SOCIAL.uri)
                .graph()
                .block(
                    GraphBlockRequest(accessJwt).also {
                        it.subject = did
                    }
                )
            uri = checkNotNull(response.data.uri)
        }

        run { // DeleteBlock
            BlueskyFactory
                .instance(Service.BSKY_SOCIAL.uri)
                .graph()
                .deleteBlock(
                    GraphDeleteBlockRequest(accessJwt).also {
                        it.uri = uri
                    }
                );
        }
    }
}
