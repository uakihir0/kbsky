package work.socialhub.kbsky.model.app.bsky.embed

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class EmbedRecordViewRecordTest {

    @Test
    fun testEmbedRecordViewRecordSerialization() {
        val json = """
            {
                "uri": "at://did:plc:abc/app.bsky.feed.post/123",
                "cid": "bafyreih",
                "author": {
                    "did": "did:plc:abc",
                    "handle": "abc.bsky.social"
                },
                "value": {
                    "text": "hello"
                },
                "replyCount": 10,
                "repostCount": 20,
                "likeCount": 30,
                "bookmarkCount": 40,
                "quoteCount": 50,
                "indexedAt": "2023-10-01T00:00:00Z"
            }
        """.trimIndent()

        val format = Json { ignoreUnknownKeys = true }
        val record = format.decodeFromString<EmbedRecordViewRecord>(json)

        assertEquals(10, record.replyCount)
        assertEquals(20, record.repostCount)
        assertEquals(30, record.likeCount)
        assertEquals(40, record.bookmarkCount)
        assertEquals(50, record.quoteCount)
    }
}
