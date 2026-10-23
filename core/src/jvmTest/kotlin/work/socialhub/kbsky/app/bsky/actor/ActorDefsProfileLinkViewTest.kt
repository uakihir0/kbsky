package work.socialhub.kbsky.app.bsky.actor

import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.model.app.bsky.actor.ActorDefsProfileViewDetailed
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/**
 * Deserialization tests for app.bsky.actor.defs#profileLinkView
 * on app.bsky.actor.defs#profileViewDetailed.
 * No network required.
 */
class ActorDefsProfileLinkViewTest {

    @Test
    fun testProfileLinksParsing() {
        val jsonString = """
        {
            "did": "did:plc:example",
            "handle": "example.bsky.social",
            "links": [
                {
                    "uri": "at://did:plc:example/app.bsky.actor.link/3lexample1",
                    "cid": "bafyreiexample1",
                    "url": "https://ko-fi.com/example",
                    "title": "Support me",
                    "icon": "https://cdn.bsky.app/img/avatar_thumbnail/plain/did:plc:example/bafkreiexample@jpeg",
                    "labels": []
                },
                {
                    "uri": "at://did:plc:example/app.bsky.actor.link/3lexample2",
                    "cid": "bafyreiexample2",
                    "url": "https://example.com/"
                }
            ]
        }
        """.trimIndent()

        val profile = fromJson<ActorDefsProfileViewDetailed>(jsonString)
        val links = assertNotNull(profile.links)
        assertEquals(2, links.size)

        assertEquals("at://did:plc:example/app.bsky.actor.link/3lexample1", links[0].uri)
        assertEquals("bafyreiexample1", links[0].cid)
        assertEquals("https://ko-fi.com/example", links[0].url)
        assertEquals("Support me", links[0].title)
        assertNotNull(links[0].icon)

        assertEquals("https://example.com/", links[1].url)
        assertNull(links[1].title)
        assertNull(links[1].icon)
        assertNull(links[1].labels)
    }

    @Test
    fun testNoProfileLinks() {
        val jsonString = """
        {
            "did": "did:plc:example",
            "handle": "example.bsky.social"
        }
        """.trimIndent()

        val profile = fromJson<ActorDefsProfileViewDetailed>(jsonString)
        assertNull(profile.links)
    }
}
