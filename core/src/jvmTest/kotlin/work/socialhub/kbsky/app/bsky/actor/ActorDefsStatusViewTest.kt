package work.socialhub.kbsky.app.bsky.actor

import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileView
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewDetailed
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsStatusView
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/**
 * Serialization/deserialization tests for app.bsky.actor.defs#statusView.
 * No network required.
 */
class ActorDefsStatusViewTest {

    @Test
    fun testStatusViewParsing() {
        val jsonString = """
        {
            "did": "did:plc:example",
            "handle": "example.bsky.social",
            "status": {
                "uri": "at://did:plc:example/app.bsky.actor.status/self",
                "cid": "bafyreiexample",
                "status": "app.bsky.actor.status#live",
                "record": {
                    "${'$'}type": "app.bsky.actor.status",
                    "status": "app.bsky.actor.status#live",
                    "embed": {
                        "${'$'}type": "app.bsky.embed.external",
                        "external": {
                            "uri": "https://stream.place/example.bsky.social",
                            "title": "Live now",
                            "description": "desc"
                        }
                    },
                    "durationMinutes": 60,
                    "createdAt": "2026-09-26T00:00:00.000Z"
                },
                "embed": {
                    "${'$'}type": "app.bsky.embed.external#view",
                    "external": {
                        "uri": "https://stream.place/example.bsky.social",
                        "title": "Live now",
                        "description": "desc",
                        "thumb": "https://cdn.bsky.app/img/feed_thumbnail/plain/example.jpg"
                    }
                },
                "labels": [
                    {
                        "src": "did:plc:labeler",
                        "uri": "at://did:plc:example/app.bsky.actor.status/self",
                        "val": "live",
                        "cts": "2026-09-26T00:00:00.000Z"
                    }
                ],
                "expiresAt": "2026-09-26T01:00:00.000Z",
                "isActive": true,
                "isDisabled": false
            }
        }
        """.trimIndent()

        val profile = fromJson<ActorDefsProfileViewBasic>(jsonString)

        val status = assertNotNull(profile.status)
        assertEquals("at://did:plc:example/app.bsky.actor.status/self", status.uri)
        assertEquals("bafyreiexample", status.cid)
        assertEquals(ActorDefsStatusView.STATUS_LIVE, status.status)
        assertEquals("2026-09-26T01:00:00.000Z", status.expiresAt)
        assertEquals(true, status.isActive)
        assertEquals(false, status.isDisabled)
        assertEquals("live", status.labels?.firstOrNull()?.`val`)

        val external = assertNotNull(status.embed?.external)
        assertEquals("https://stream.place/example.bsky.social", external.uri)
        assertEquals("Live now", external.title)
        assertEquals("https://cdn.bsky.app/img/feed_thumbnail/plain/example.jpg", external.thumb)

        // Round trip: every represented field survives re-encoding.
        val roundTripped = fromJson<ActorDefsStatusView>(toJson(status))
        assertEquals(status.uri, roundTripped.uri)
        assertEquals(status.cid, roundTripped.cid)
        assertEquals(status.status, roundTripped.status)
        assertEquals(status.expiresAt, roundTripped.expiresAt)
        assertEquals(status.isActive, roundTripped.isActive)
        assertEquals(status.isDisabled, roundTripped.isDisabled)
        assertEquals(status.labels?.firstOrNull()?.`val`, roundTripped.labels?.firstOrNull()?.`val`)
        assertEquals(external.uri, roundTripped.embed?.external?.uri)
    }

    @Test
    fun testStatusViewOnProfileViews() {
        // The status field is also exposed on profileView / profileViewDetailed.
        val jsonString = """
        {
            "did": "did:plc:example",
            "handle": "example.bsky.social",
            "status": {
                "status": "app.bsky.actor.status#live"
            }
        }
        """.trimIndent()

        assertEquals(
            ActorDefsStatusView.STATUS_LIVE,
            assertNotNull(fromJson<ActorDefsProfileView>(jsonString).status).status,
        )
        assertEquals(
            ActorDefsStatusView.STATUS_LIVE,
            assertNotNull(fromJson<ActorDefsProfileViewDetailed>(jsonString).status).status,
        )
    }

    @Test
    fun testNoStatus() {
        val jsonString = """
        {
            "did": "did:plc:example",
            "handle": "example.bsky.social"
        }
        """.trimIndent()

        val profile = fromJson<ActorDefsProfileViewBasic>(jsonString)
        assertNull(profile.status)
    }
}
