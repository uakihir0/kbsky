package work.socialhub.kbsky.app.bsky.unspecced

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPostThreadV2Request
import work.socialhub.kbsky.api.entity.app.bsky.unspecced.UnspeccedGetPostThreadV2Response
import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemBlocked
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemNoUnauthenticated
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemNotFound
import work.socialhub.kbsky.model.app.bsky.unspecced.UnspeccedDefsThreadItemPost
import work.socialhub.kbsky.util.json.UnspeccedDefsThreadItemPolymorphicSerializer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class GetPostThreadV2Test : AbstractTest() {

    @Test
    fun testGetPostThreadV2() = runTest {
        // The first post of a contiguous OP thread by bsky.app
        val anchor = "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.feed.post/3mtwf7gxkwc2r"

        val response = client()
            .unspecced()
            .getPostThreadV2(
                UnspeccedGetPostThreadV2Request(auth()).also {
                    it.anchor = anchor
                }
            )

        println("hasOtherReplies: " + response.data.hasOtherReplies)

        val thread = response.data.thread
        assertTrue(thread.isNotEmpty(), "thread is empty.")

        // The first item must be the anchor itself
        val first = thread.first()
        assertEquals(anchor, first.uri)
        assertEquals(0, first.depth)
        val firstPost = assertNotNull(first.value?.asPost, "the first item is not a threadItemPost.")
        assertEquals(anchor, firstPost.post?.uri)

        // OP thread metadata must be populated
        assertTrue(firstPost.opThread, "the first item is not part of the OP thread.")
        assertEquals(1, firstPost.opThreadPostIndex)
        assertNotNull(firstPost.opThreadPostCount)

        thread.forEach { item ->
            val post = item.value?.asPost
            println(
                "depth=" + item.depth +
                        ", uri=" + item.uri +
                        ", opThread=" + post?.opThread +
                        ", opThreadPostIndex=" + post?.opThreadPostIndex +
                        ", opThreadPostCount=" + post?.opThreadPostCount
            )

            // Every item must have a uri and a value
            assertTrue(item.uri.startsWith("at://"), "uri: ${item.uri}")
            assertNotNull(item.value, "value is missing: ${item.uri}")

            // OP thread posts carry index / count; other posts do not
            if (post != null) {
                if (post.opThread) {
                    assertNotNull(post.opThreadPostIndex, "opThreadPostIndex is missing: ${item.uri}")
                    assertNotNull(post.opThreadPostCount, "opThreadPostCount is missing: ${item.uri}")
                } else {
                    assertNull(post.opThreadPostIndex, "opThreadPostIndex is unexpectedly present: ${item.uri}")
                    assertNull(post.opThreadPostCount, "opThreadPostCount is unexpectedly present: ${item.uri}")
                }
            }
        }
    }

    @Test
    fun testResponseDeserialize() {
        // A response containing every threadItem variant deserializes correctly (no network required)
        val json = """
            {
              "thread": [
                {
                  "uri": "at://did:plc:op/app.bsky.feed.post/root",
                  "depth": 0,
                  "value": {
                    "${'$'}type": "app.bsky.unspecced.defs#threadItemPost",
                    "post": {
                      "${'$'}type": "app.bsky.feed.defs#postView",
                      "uri": "at://did:plc:op/app.bsky.feed.post/root",
                      "cid": "bafyroot",
                      "author": { "did": "did:plc:op", "handle": "op.example.com" },
                      "record": { "${'$'}type": "app.bsky.feed.post", "text": "root", "createdAt": "2026-09-01T00:00:00.000Z" },
                      "replyCount": 3,
                      "indexedAt": "2026-09-01T00:00:00.000Z"
                    },
                    "moreParents": false,
                    "moreReplies": 2,
                    "opThread": true,
                    "opThreadPostIndex": 1,
                    "opThreadPostCount": 3,
                    "hiddenByThreadgate": false,
                    "mutedByViewer": false
                  }
                },
                {
                  "uri": "at://did:plc:other/app.bsky.feed.post/reply",
                  "depth": 1,
                  "value": {
                    "${'$'}type": "app.bsky.unspecced.defs#threadItemPost",
                    "post": {
                      "${'$'}type": "app.bsky.feed.defs#postView",
                      "uri": "at://did:plc:other/app.bsky.feed.post/reply",
                      "cid": "bafyreply",
                      "author": { "did": "did:plc:other", "handle": "other.example.com" },
                      "record": { "${'$'}type": "app.bsky.feed.post", "text": "reply", "createdAt": "2026-09-01T00:01:00.000Z" },
                      "indexedAt": "2026-09-01T00:01:00.000Z"
                    },
                    "moreParents": false,
                    "moreReplies": 0,
                    "opThread": false,
                    "hiddenByThreadgate": true,
                    "mutedByViewer": true
                  }
                },
                {
                  "uri": "at://did:plc:blocked/app.bsky.feed.post/blocked",
                  "depth": 1,
                  "value": {
                    "${'$'}type": "app.bsky.unspecced.defs#threadItemBlocked",
                    "author": {
                      "did": "did:plc:blocked",
                      "viewer": { "blockedBy": true }
                    }
                  }
                },
                {
                  "uri": "at://did:plc:gone/app.bsky.feed.post/gone",
                  "depth": 1,
                  "value": { "${'$'}type": "app.bsky.unspecced.defs#threadItemNotFound" }
                },
                {
                  "uri": "at://did:plc:private/app.bsky.feed.post/private",
                  "depth": 1,
                  "value": { "${'$'}type": "app.bsky.unspecced.defs#threadItemNoUnauthenticated" }
                },
                {
                  "uri": "at://did:plc:future/app.bsky.feed.post/future",
                  "depth": 1,
                  "value": { "${'$'}type": "app.bsky.unspecced.defs#threadItemSomethingNew" }
                }
              ],
              "threadgate": {
                "uri": "at://did:plc:op/app.bsky.feed.threadgate/root",
                "cid": "bafygate"
              },
              "hasOtherReplies": true
            }
        """.trimIndent()

        val response = fromJson<UnspeccedGetPostThreadV2Response>(json)

        assertEquals(true, response.hasOtherReplies)
        assertEquals("at://did:plc:op/app.bsky.feed.threadgate/root", response.threadgate?.uri)
        assertEquals(6, response.thread.size)

        // threadItemPost (part of the OP thread)
        val root = response.thread[0]
        assertEquals("at://did:plc:op/app.bsky.feed.post/root", root.uri)
        assertEquals(0, root.depth)
        val rootPost = assertIs<UnspeccedDefsThreadItemPost>(root.value)
        assertEquals(UnspeccedDefsThreadItemPost.TYPE, rootPost.type)
        assertEquals("at://did:plc:op/app.bsky.feed.post/root", rootPost.post?.uri)
        assertEquals("op.example.com", rootPost.post?.author?.handle)
        assertEquals(3, rootPost.post?.replyCount)
        assertFalse(rootPost.moreParents)
        assertEquals(2, rootPost.moreReplies)
        assertTrue(rootPost.opThread)
        assertEquals(1, rootPost.opThreadPostIndex)
        assertEquals(3, rootPost.opThreadPostCount)
        assertFalse(rootPost.hiddenByThreadgate)
        assertFalse(rootPost.mutedByViewer)
        // union accessors
        assertNotNull(root.value?.asPost)
        assertNull(root.value?.asBlocked)
        assertNull(root.value?.asNotFound)
        assertNull(root.value?.asNoUnauthenticated)

        // threadItemPost (a reply that is not part of the OP thread)
        val reply = response.thread[1]
        assertEquals(1, reply.depth)
        val replyPost = assertNotNull(reply.value?.asPost)
        assertFalse(replyPost.opThread)
        assertNull(replyPost.opThreadPostIndex)
        assertNull(replyPost.opThreadPostCount)
        assertEquals(0, replyPost.moreReplies)
        assertTrue(replyPost.hiddenByThreadgate)
        assertTrue(replyPost.mutedByViewer)

        // threadItemBlocked
        val blocked = assertIs<UnspeccedDefsThreadItemBlocked>(response.thread[2].value)
        assertEquals(UnspeccedDefsThreadItemBlocked.TYPE, blocked.type)
        assertEquals("did:plc:blocked", blocked.author?.did)
        assertEquals(true, blocked.author?.viewer?.blockedBy)
        assertNotNull(response.thread[2].value?.asBlocked)
        assertNull(response.thread[2].value?.asPost)

        // threadItemNotFound
        val notFound = assertIs<UnspeccedDefsThreadItemNotFound>(response.thread[3].value)
        assertEquals(UnspeccedDefsThreadItemNotFound.TYPE, notFound.type)
        assertNotNull(response.thread[3].value?.asNotFound)

        // threadItemNoUnauthenticated
        val noAuth = assertIs<UnspeccedDefsThreadItemNoUnauthenticated>(response.thread[4].value)
        assertEquals(UnspeccedDefsThreadItemNoUnauthenticated.TYPE, noAuth.type)
        assertNotNull(response.thread[4].value?.asNoUnauthenticated)

        // An unknown ${'$'}type falls back to Unknown without breaking the other items
        val unknown = assertIs<UnspeccedDefsThreadItemPolymorphicSerializer.Unknown>(response.thread[5].value)
        assertEquals("at://did:plc:future/app.bsky.feed.post/future", response.thread[5].uri)
        assertNull(unknown.asPost)
        assertNull(unknown.asBlocked)
        assertNull(unknown.asNotFound)
        assertNull(unknown.asNoUnauthenticated)
    }

    @Test
    fun testResponseDeserializeMinimal() {
        // A response without threadgate or OP thread fields still deserializes
        val json = """
            {
              "thread": [
                {
                  "uri": "at://did:plc:op/app.bsky.feed.post/root",
                  "depth": 0,
                  "value": {
                    "${'$'}type": "app.bsky.unspecced.defs#threadItemPost",
                    "post": {
                      "${'$'}type": "app.bsky.feed.defs#postView",
                      "uri": "at://did:plc:op/app.bsky.feed.post/root",
                      "cid": "bafyroot",
                      "author": { "did": "did:plc:op", "handle": "op.example.com" },
                      "record": { "${'$'}type": "app.bsky.feed.post", "text": "root", "createdAt": "2026-09-01T00:00:00.000Z" },
                      "indexedAt": "2026-09-01T00:00:00.000Z"
                    },
                    "moreParents": false,
                    "moreReplies": 0,
                    "opThread": false,
                    "hiddenByThreadgate": false,
                    "mutedByViewer": false
                  }
                }
              ],
              "hasOtherReplies": false
            }
        """.trimIndent()

        val response = fromJson<UnspeccedGetPostThreadV2Response>(json)

        assertEquals(false, response.hasOtherReplies)
        assertNull(response.threadgate)
        assertEquals(1, response.thread.size)
        val post = assertNotNull(response.thread[0].value?.asPost)
        assertFalse(post.opThread)
        assertNull(post.opThreadPostIndex)
        assertNull(post.opThreadPostCount)
    }
}
