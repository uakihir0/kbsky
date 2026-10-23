package work.socialhub.kbsky.app.bsky.actor

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import work.socialhub.kbsky.api.entity.app.bsky.actor.ActorUpdateProfileRequest
import work.socialhub.kbsky.auth.BearerTokenAuthProvider
import work.socialhub.kbsky.internal.app.bsky.ActorResourceImpl
import work.socialhub.kbsky.internal.share.InternalUtility.json
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull

/**
 * Tests that updateProfile keeps fields it doesn't handle (links, pronouns, etc.).
 * No network required.
 */
class UpdateProfileMergeTest {

    private val originalRecord = json.parseToJsonElement(
        """
        {
            "${'$'}type": "app.bsky.actor.profile",
            "displayName": "Old Name",
            "description": "Old description",
            "avatar": {"${'$'}type": "blob", "ref": {"${'$'}link": "bafkreiavatar"}, "mimeType": "image/jpeg", "size": 1000},
            "banner": {"${'$'}type": "blob", "ref": {"${'$'}link": "bafkreibanner"}, "mimeType": "image/jpeg", "size": 2000},
            "pinnedPost": {"uri": "at://did:plc:example/app.bsky.feed.post/3lpinned", "cid": "bafyreipinned"},
            "pronouns": "they/them",
            "website": "https://example.com",
            "links": [
                {"uri": "at://did:plc:example/app.bsky.actor.link/3llink1", "cid": "bafyreilink1"}
            ],
            "labels": {"${'$'}type": "com.atproto.label.defs#selfLabels", "values": [{"val": "!no-unauthenticated"}]},
            "createdAt": "2024-01-01T00:00:00.000Z"
        }
        """.trimIndent()
    ).jsonObject

    private val auth = BearerTokenAuthProvider("dummy")

    @Test
    fun testUnknownFieldsAreKept() {
        val merged = ActorResourceImpl.mergeProfileRecord(
            originalRecord,
            ActorUpdateProfileRequest(auth = auth, displayName = "New Name"),
        )

        assertEquals("New Name", merged["displayName"]?.jsonPrimitive?.content)
        assertEquals("Old description", merged["description"]?.jsonPrimitive?.content)

        // fields not handled by ActorProfile must survive
        assertEquals(originalRecord["links"], merged["links"])
        assertEquals(1, merged["links"]?.jsonArray?.size)
        assertEquals(originalRecord["pronouns"], merged["pronouns"])
        assertEquals(originalRecord["website"], merged["website"])
        assertEquals(originalRecord["labels"], merged["labels"])
        assertEquals(originalRecord["createdAt"], merged["createdAt"])
        assertEquals(originalRecord["\$type"], merged["\$type"])

        // blobs must be passed through untouched
        assertEquals(originalRecord["avatar"], merged["avatar"])
        assertEquals(originalRecord["banner"], merged["banner"])
        assertEquals(originalRecord["pinnedPost"], merged["pinnedPost"])
    }

    @Test
    fun testClearBannerAndPinnedPost() {
        val merged = ActorResourceImpl.mergeProfileRecord(
            originalRecord,
            ActorUpdateProfileRequest(auth = auth, clearBanner = true, clearPinnedPost = true),
        )

        assertFalse(merged.containsKey("banner"))
        assertFalse(merged.containsKey("pinnedPost"))
        assertEquals(originalRecord["links"], merged["links"])
    }

    @Test
    fun testReplacePinnedPost() {
        val merged = ActorResourceImpl.mergeProfileRecord(
            originalRecord,
            ActorUpdateProfileRequest(
                auth = auth,
                pinnedPost = RepoStrongRef(uri = "at://did:plc:example/app.bsky.feed.post/3lnew", cid = "bafyreinew"),
            ),
        )

        val pinnedPost = assertNotNull(merged["pinnedPost"] as? JsonObject)
        assertEquals("at://did:plc:example/app.bsky.feed.post/3lnew", pinnedPost["uri"]?.jsonPrimitive?.content)
        assertEquals("bafyreinew", pinnedPost["cid"]?.jsonPrimitive?.content)
        assertEquals(originalRecord["links"], merged["links"])
    }
}
