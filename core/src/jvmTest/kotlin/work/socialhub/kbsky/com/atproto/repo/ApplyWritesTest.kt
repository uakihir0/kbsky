package work.socialhub.kbsky.com.atproto.repo

import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostgateRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedThreadgateRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoApplyWritesCreate
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoApplyWritesDelete
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoApplyWritesRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoApplyWritesResponse
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoApplyWritesResult
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoApplyWritesUpdate
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.json
import work.socialhub.kbsky.model.app.bsky.feed.FeedPost
import work.socialhub.kbsky.model.app.bsky.feed.FeedPostgateDisableRule
import work.socialhub.kbsky.model.app.bsky.feed.FeedThreadgateMentionRule
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.util.json.RecordJsonUtil
import java.util.Base64
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Tests for com.atproto.repo.applyWrites. No network required.
 */
class ApplyWritesTest {

    // dummy JWT whose "sub" is did:plc:example
    private val auth = BearerTokenAuthProvider(
        "eyJhbGciOiJub25lIn0." +
                Base64.getEncoder().encodeToString("""{"sub":"did:plc:example"}""".toByteArray()) +
                ".sig"
    )

    @Test
    fun testRequestJson() {
        val value = buildJsonObject {
            put("\$type", JsonPrimitive("com.example.article"))
            put("title", JsonPrimitive("Hello"))
        }

        val request = RepoApplyWritesRequest(
            auth = auth,
            repo = "did:plc:example",
            validate = false,
            writes = listOf(
                RepoApplyWritesCreate(
                    collection = "com.example.article",
                    rkey = "3kcreate",
                    value = value,
                ),
                RepoApplyWritesUpdate(
                    collection = "com.example.article",
                    rkey = "3kupdate",
                    value = value,
                ),
                RepoApplyWritesDelete(
                    collection = "com.example.article",
                    rkey = "3kdelete",
                ),
            ),
            swapCommit = "bafyreicommit",
        )

        val body = json.parseToJsonElement(request.toMappedJson()).jsonObject
        assertEquals("did:plc:example", body["repo"]?.jsonPrimitive?.content)
        assertEquals("false", body["validate"]?.jsonPrimitive?.content)
        assertEquals("bafyreicommit", body["swapCommit"]?.jsonPrimitive?.content)

        val writes = checkNotNull(body["writes"]).jsonArray
        assertEquals(3, writes.size)

        val create = writes[0].jsonObject
        assertEquals("com.atproto.repo.applyWrites#create", create["\$type"]?.jsonPrimitive?.content)
        assertEquals("com.example.article", create["collection"]?.jsonPrimitive?.content)
        assertEquals("3kcreate", create["rkey"]?.jsonPrimitive?.content)
        // the value is sent as is
        assertEquals(value, create["value"])

        val update = writes[1].jsonObject
        assertEquals("com.atproto.repo.applyWrites#update", update["\$type"]?.jsonPrimitive?.content)
        assertEquals("3kupdate", update["rkey"]?.jsonPrimitive?.content)
        assertEquals(value, update["value"])

        val delete = writes[2].jsonObject
        assertEquals("com.atproto.repo.applyWrites#delete", delete["\$type"]?.jsonPrimitive?.content)
        assertEquals("3kdelete", delete["rkey"]?.jsonPrimitive?.content)
        assertNull(delete["value"])
    }

    @Test
    fun testRequestJsonDefaults() {
        val request = RepoApplyWritesRequest(
            auth = auth,
            writes = listOf(
                RepoApplyWritesCreate(
                    collection = "com.example.article",
                    value = buildJsonObject { put("\$type", JsonPrimitive("com.example.article")) },
                ),
            ),
        )

        val body = request.toJsonObject()
        // repo falls back to the DID of the auth
        assertEquals("did:plc:example", body["repo"]?.jsonPrimitive?.content)
        // unset optional fields are not written
        assertNull(body["validate"])
        assertNull(body["swapCommit"])
        assertNull(checkNotNull(body["writes"]).jsonArray[0].jsonObject["rkey"])
    }

    @Test
    fun testCreateFromRecord() {
        val post = FeedPost(
            text = "Hello",
            createdAt = "2026-11-15T00:00:00.000Z",
        )

        val write = RepoApplyWritesCreate.fromRecord(
            collection = FeedPost.TYPE,
            record = post,
            rkey = "3kpost",
        )
        assertEquals("app.bsky.feed.post", write.value["\$type"]?.jsonPrimitive?.content)
        assertEquals("Hello", write.value["text"]?.jsonPrimitive?.content)
    }

    @Test
    fun testRecordJsonIsSameAsCreateRecord() {
        val postRequest = FeedPostRequest(
            auth = auth,
            text = "Hello",
            langs = listOf("ja"),
            createdAt = "2026-11-15T00:00:00.000Z",
            mochottLongPost = RepoStrongRef(
                uri = "at://did:plc:example/site.mochott.article/3karticle",
                cid = "bafyreiarticle",
            ),
        )
        val threadgateRequest = FeedThreadgateRequest(
            auth = auth,
            createdAt = "2026-11-15T00:00:00.000Z",
            post = "at://did:plc:example/app.bsky.feed.post/3kpost",
            allow = listOf(FeedThreadgateMentionRule()),
        )
        val postgateRequest = FeedPostgateRequest(
            auth = auth,
            createdAt = "2026-11-15T00:00:00.000Z",
            post = "at://did:plc:example/app.bsky.feed.post/3kpost",
            embeddingRules = listOf(FeedPostgateDisableRule()),
        )

        listOf(
            postRequest.toPost(),
            threadgateRequest.toThreadgate(),
            postgateRequest.toPostgate(),
        ).forEach { record ->
            val createRecord = RepoCreateRecordRequest(
                auth = auth,
                repo = "did:plc:example",
                collection = record.type,
                record = record,
            )
            val expected = json.parseToJsonElement(createRecord.toMappedJson()).jsonObject["record"]
            assertNotNull(expected)
            assertEquals(expected, RecordJsonUtil.toJsonObject(record))
        }
    }

    @Test
    fun testDecodeResponse() {
        val response = fromJson<RepoApplyWritesResponse>(
            """
            {
                "commit": {"cid": "bafyreicommit", "rev": "3kcommitrev", "unknownField": 1},
                "results": [
                    {
                        "${'$'}type": "com.atproto.repo.applyWrites#createResult",
                        "uri": "at://did:plc:example/com.example.article/3kcreate",
                        "cid": "bafyreicreate",
                        "validationStatus": "unknown"
                    },
                    {
                        "${'$'}type": "com.atproto.repo.applyWrites#updateResult",
                        "uri": "at://did:plc:example/com.example.article/3kupdate",
                        "cid": "bafyreiupdate",
                        "validationStatus": "valid"
                    },
                    {
                        "${'$'}type": "com.atproto.repo.applyWrites#deleteResult"
                    }
                ]
            }
            """.trimIndent()
        )

        assertEquals("bafyreicommit", response.commit?.cid)
        assertEquals("3kcommitrev", response.commit?.rev)

        val results = checkNotNull(response.results)
        assertEquals(3, results.size)

        assertTrue(results[0].isCreateResult)
        assertEquals("at://did:plc:example/com.example.article/3kcreate", results[0].uri)
        assertEquals("bafyreicreate", results[0].cid)
        assertEquals("unknown", results[0].validationStatus)

        assertTrue(results[1].isUpdateResult)
        assertEquals("bafyreiupdate", results[1].cid)
        assertEquals("valid", results[1].validationStatus)

        assertTrue(results[2].isDeleteResult)
        assertEquals(RepoApplyWritesResult.DELETE_RESULT, results[2].type)
        assertNull(results[2].uri)
        assertNull(results[2].cid)
    }

    @Test
    fun testDecodeEmptyResponse() {
        val response = fromJson<RepoApplyWritesResponse>("{}")
        assertNull(response.commit)
        assertNull(response.results)
    }
}
