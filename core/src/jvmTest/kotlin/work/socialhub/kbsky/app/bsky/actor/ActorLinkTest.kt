package work.socialhub.kbsky.app.bsky.actor

import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoCreateRecordRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordResponse
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.json
import work.socialhub.kbsky.model.app.bsky.actor.ActorLink
import work.socialhub.kbsky.model.share.Blob
import work.socialhub.kbsky.model.share.BlobRef
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/**
 * Tests for the app.bsky.actor.link record. No network required.
 */
class ActorLinkTest {

    @Test
    fun testDecodeFromGetRecord() {
        val response = fromJson<RepoGetRecordResponse>(
            """
            {
                "uri": "at://did:plc:example/app.bsky.actor.link/3llink1",
                "cid": "bafyreilink1",
                "value": {
                    "${'$'}type": "app.bsky.actor.link",
                    "url": "https://example.com/shop",
                    "title": "My shop",
                    "icon": {"${'$'}type": "blob", "ref": {"${'$'}link": "bafkreiicon"}, "mimeType": "image/png", "size": 1234},
                    "createdAt": "2026-11-13T00:00:00.000Z",
                    "labels": {"${'$'}type": "com.atproto.label.defs#selfLabels", "values": [{"val": "porn"}]}
                }
            }
            """.trimIndent()
        )

        val link = response.value.asActorLink
        assertNotNull(link)
        assertEquals("https://example.com/shop", link.url)
        assertEquals("My shop", link.title)
        assertEquals("image/png", link.icon?.mimeType)
        assertEquals("2026-11-13T00:00:00.000Z", link.createdAt)
        assertEquals("porn", link.labels?.values?.firstOrNull()?.`val`)
    }

    @Test
    fun testDecodeWithoutOptionalFields() {
        val response = fromJson<RepoGetRecordResponse>(
            """
            {
                "uri": "at://did:plc:example/app.bsky.actor.link/3llink2",
                "cid": "bafyreilink2",
                "value": {
                    "${'$'}type": "app.bsky.actor.link",
                    "url": "https://example.com/",
                    "createdAt": "2026-11-13T00:00:00.000Z"
                }
            }
            """.trimIndent()
        )

        val link = response.value.asActorLink
        assertNotNull(link)
        assertEquals("https://example.com/", link.url)
        assertNull(link.title)
        assertNull(link.icon)
        assertNull(link.labels)
    }

    @Test
    fun testEncodeForCreateRecord() {
        val request = RepoCreateRecordRequest(
            auth = BearerTokenAuthProvider("dummy"),
            repo = "did:plc:example",
            collection = ActorLink.TYPE,
            record = ActorLink(
                url = "https://example.com/shop",
                title = "My shop",
                icon = Blob().also {
                    it.ref = BlobRef().also { r -> r.link = "bafkreiicon" }
                    it.mimeType = "image/png"
                    it.size = 1234
                },
                createdAt = "2026-11-13T00:00:00.000Z",
            ),
        )

        val body = json.parseToJsonElement(request.toMappedJson()).jsonObject
        assertEquals("app.bsky.actor.link", body["collection"]?.jsonPrimitive?.content)

        val record = body["record"]?.jsonObject
        assertNotNull(record)
        assertEquals("app.bsky.actor.link", record["${'$'}type"]?.jsonPrimitive?.content)
        assertEquals("https://example.com/shop", record["url"]?.jsonPrimitive?.content)
        assertEquals("My shop", record["title"]?.jsonPrimitive?.content)
        assertEquals("image/png", record["icon"]?.jsonObject?.get("mimeType")?.jsonPrimitive?.content)
        // unset optional fields are not written
        assertNull(record["labels"])
    }
}
