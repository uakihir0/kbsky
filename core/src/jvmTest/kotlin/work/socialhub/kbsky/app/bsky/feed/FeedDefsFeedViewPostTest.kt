package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.model.app.bsky.embed.EmbedRecordViewRecord
import work.socialhub.kbsky.model.app.bsky.feed.FeedDefsFeedViewPost
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Deserialization tests for opThreadPostIndex / opThreadPostCount on
 * app.bsky.feed.defs#feedViewPost and app.bsky.embed.record#viewRecord.
 * No network required.
 */
class FeedDefsFeedViewPostTest {

    private fun feedViewPostJson(opThread: String): String = """
        {
            "post": {
                "uri": "at://did:plc:example/app.bsky.feed.post/3lexample",
                "cid": "bafyreiexample",
                "author": {
                    "did": "did:plc:example",
                    "handle": "example.bsky.social"
                },
                "record": {
                    "${'$'}type": "app.bsky.feed.post",
                    "text": "hello",
                    "createdAt": "2025-08-06T03:43:31.609Z"
                },
                "indexedAt": "2025-08-06T03:43:31.609Z"
            }$opThread
        }
        """.trimIndent()

    private fun viewRecordJson(opThread: String): String = """
        {
            "${'$'}type": "app.bsky.embed.record#viewRecord",
            "uri": "at://did:plc:example/app.bsky.feed.post/3lexample",
            "cid": "bafyreiexample",
            "author": {
                "did": "did:plc:example",
                "handle": "example.bsky.social"
            },
            "value": {
                "${'$'}type": "app.bsky.feed.post",
                "text": "hello",
                "createdAt": "2025-08-06T03:43:31.609Z"
            },
            "quoteCount": 0,$opThread
            "indexedAt": "2025-08-06T03:43:31.609Z"
        }
        """.trimIndent()

    @Test
    fun testFeedViewPostOpThread() {
        val json = feedViewPostJson(""",
            "opThreadPostIndex": 2,
            "opThreadPostCount": 3""")

        val feed = fromJson<FeedDefsFeedViewPost>(json)
        assertEquals("at://did:plc:example/app.bsky.feed.post/3lexample", feed.post.uri)
        assertEquals(2, feed.opThreadPostIndex)
        assertEquals(3, feed.opThreadPostCount)
    }

    @Test
    fun testFeedViewPostNoOpThread() {
        val feed = fromJson<FeedDefsFeedViewPost>(feedViewPostJson(""))
        assertEquals("at://did:plc:example/app.bsky.feed.post/3lexample", feed.post.uri)
        assertNull(feed.opThreadPostIndex)
        assertNull(feed.opThreadPostCount)
    }

    @Test
    fun testViewRecordOpThread() {
        val json = viewRecordJson("""
            "opThreadPostIndex": 1,
            "opThreadPostCount": 4,""")

        val record = fromJson<EmbedRecordViewRecord>(json)
        assertEquals("bafyreiexample", record.cid)
        assertEquals(1, record.opThreadPostIndex)
        assertEquals(4, record.opThreadPostCount)
    }

    @Test
    fun testViewRecordNoOpThread() {
        val record = fromJson<EmbedRecordViewRecord>(viewRecordJson(""))
        assertEquals("bafyreiexample", record.cid)
        assertNull(record.opThreadPostIndex)
        assertNull(record.opThreadPostCount)
    }
}
