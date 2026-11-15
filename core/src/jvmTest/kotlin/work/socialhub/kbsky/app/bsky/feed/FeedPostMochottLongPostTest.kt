package work.socialhub.kbsky.app.bsky.feed

import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordResponse
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.json
import work.socialhub.kbsky.model.app.bsky.feed.FeedPost
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/**
 * Tests for the site.mochott.longPost field of app.bsky.feed.post. No network required.
 */
class FeedPostMochottLongPostTest {

    @Test
    fun testDecode() {
        val response = fromJson<RepoGetRecordResponse>(
            """
            {
                "uri": "at://did:plc:example/app.bsky.feed.post/3kpost",
                "cid": "bafyreipost",
                "value": {
                    "${'$'}type": "app.bsky.feed.post",
                    "text": "Hello",
                    "createdAt": "2026-11-15T00:00:00.000Z",
                    "site.mochott.longPost": {
                        "uri": "at://did:plc:example/site.mochott.article/3karticle",
                        "cid": "bafyreiarticle"
                    }
                }
            }
            """.trimIndent()
        )

        val post = response.value.asFeedPost
        assertNotNull(post)
        assertEquals("at://did:plc:example/site.mochott.article/3karticle", post.mochottLongPost?.uri)
        assertEquals("bafyreiarticle", post.mochottLongPost?.cid)
    }

    @Test
    fun testDecodeWithoutLongPost() {
        val response = fromJson<RepoGetRecordResponse>(
            """
            {
                "uri": "at://did:plc:example/app.bsky.feed.post/3kpost",
                "cid": "bafyreipost",
                "value": {
                    "${'$'}type": "app.bsky.feed.post",
                    "text": "Hello",
                    "createdAt": "2026-11-15T00:00:00.000Z"
                }
            }
            """.trimIndent()
        )

        val post = response.value.asFeedPost
        assertNotNull(post)
        assertNull(post.mochottLongPost)
    }

    @Test
    fun testEncode() {
        val auth = BearerTokenAuthProvider("dummy")
        val postRequest = FeedPostRequest(
            auth = auth,
            text = "Hello",
            createdAt = "2026-11-15T00:00:00.000Z",
            mochottLongPost = RepoStrongRef(
                uri = "at://did:plc:example/site.mochott.article/3karticle",
                cid = "bafyreiarticle",
            ),
        )

        val request = RepoCreateRecordRequest(
            auth = auth,
            repo = "did:plc:example",
            collection = FeedPost.TYPE,
            record = postRequest.toPost(),
        )

        val record = json.parseToJsonElement(request.toMappedJson()).jsonObject["record"]?.jsonObject
        assertNotNull(record)
        val longPost = record["site.mochott.longPost"]?.jsonObject
        assertNotNull(longPost)
        assertEquals("at://did:plc:example/site.mochott.article/3karticle", longPost["uri"]?.jsonPrimitive?.content)
        assertEquals("bafyreiarticle", longPost["cid"]?.jsonPrimitive?.content)
    }

    @Test
    fun testEncodeWithoutLongPost() {
        val auth = BearerTokenAuthProvider("dummy")
        val request = RepoCreateRecordRequest(
            auth = auth,
            repo = "did:plc:example",
            collection = FeedPost.TYPE,
            record = FeedPostRequest(auth = auth, text = "Hello").toPost(),
        )

        val record = json.parseToJsonElement(request.toMappedJson()).jsonObject["record"]?.jsonObject
        assertNotNull(record)
        assertNull(record["site.mochott.longPost"])
    }
}
