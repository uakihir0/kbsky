package work.socialhub.kbsky.app.bsky.actor

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewBasic
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsStatusView
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class ActorDefsStatusViewTest : AbstractTest() {

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
                "expiresAt": "2026-09-26T01:00:00.000Z",
                "isActive": true
            }
        }
        """.trimIndent()

        val profile = json.decodeFromString<ActorDefsProfileViewBasic>(jsonString)

        val status = assertNotNull(profile.status)
        assertEquals(ActorDefsStatusView.STATUS_LIVE, status.status)
        assertEquals("2026-09-26T01:00:00.000Z", status.expiresAt)
        assertEquals(true, status.isActive)
        assertNull(status.isDisabled)

        val external = assertNotNull(status.embed?.external)
        assertEquals("https://stream.place/example.bsky.social", external.uri)
        assertEquals("Live now", external.title)
        assertEquals("https://cdn.bsky.app/img/feed_thumbnail/plain/example.jpg", external.thumb)
    }

    @Test
    fun testNoStatus() {
        val jsonString = """
        {
            "did": "did:plc:example",
            "handle": "example.bsky.social"
        }
        """.trimIndent()

        val profile = json.decodeFromString<ActorDefsProfileViewBasic>(jsonString)
        assertNull(profile.status)
    }
}
