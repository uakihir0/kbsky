package work.socialhub.kbsky.app.bsky.embed

import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.embed.EmbedExternal
import work.socialhub.kbsky.model.app.bsky.embed.EmbedExternalExternal
import work.socialhub.kbsky.model.app.bsky.embed.EmbedExternalView
import work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Serialization/deserialization tests for the enhanced external embed
 * (standard.site link cards). No network required.
 */
class EmbedExternalStandardSiteTest {

    @Test
    fun testStandardSiteViewParsing() {
        // Based on a real response from app.bsky.feed.getAuthorFeed (leaflet.pub).
        val jsonString = """
        {
          "${'$'}type": "app.bsky.embed.external#view",
          "external": {
            "uri": "https://lab.leaflet.pub/3mwehnrqsf22g",
            "title": "Back to School — Leaflet for Learning",
            "description": "Lab Notes 037",
            "thumb": "https://cdn.bsky.app/img/feed_thumbnail/plain/did:plc:btxrwcaeyodrap5mnjw2fvmz/bafkreicombnbkzakblorwdvynwbp55pr34ekwqn3nfidyacxsgxf7ty4ra",
            "createdAt": "2026-09-25T19:05:46.382Z",
            "updatedAt": "2026-09-26T08:30:00.000Z",
            "readingTime": 4,
            "labels": [
              {
                "src": "did:plc:labeler",
                "uri": "https://lab.leaflet.pub/3mwehnrqsf22g",
                "val": "news",
                "cts": "2026-09-25T19:05:46.382Z"
              }
            ],
            "source": {
              "uri": "https://lab.leaflet.pub",
              "icon": "https://cdn.bsky.app/img/avatar/plain/did:plc:btxrwcaeyodrap5mnjw2fvmz/bafkreicchgde2juzzjey4opdbbh7h26mmi4c4pcbg7pc3muhmixb6mrm3u",
              "title": "Leaflet Lab Notes",
              "description": "Behind the scenes as we build Leaflet",
              "theme": {
                "backgroundRGB": {"r": 255, "g": 255, "b": 255, "${'$'}type": "app.bsky.embed.external#colorRGB"},
                "foregroundRGB": {"r": 0, "g": 0, "b": 0, "${'$'}type": "app.bsky.embed.external#colorRGB"},
                "accentRGB": {"r": 116, "g": 145, "b": 0, "${'$'}type": "app.bsky.embed.external#colorRGB"},
                "accentForegroundRGB": {"r": 255, "g": 255, "b": 255, "${'$'}type": "app.bsky.embed.external#colorRGB"}
              },
              "${'$'}type": "app.bsky.embed.external#viewExternalSource"
            },
            "associatedProfiles": [
              {
                "did": "did:plc:btxrwcaeyodrap5mnjw2fvmz",
                "handle": "leaflet.pub",
                "displayName": "Leaflet",
                "avatar": "https://cdn.bsky.app/img/avatar/plain/did:plc:btxrwcaeyodrap5mnjw2fvmz/bafkreibtqvoiyw5iqic3hocno5chkgzuqlflapclxzedslfdottcoud27a",
                "labels": [],
                "createdAt": "2024-10-21T20:21:02.913Z"
              }
            ],
            "associatedRefs": [
              {
                "${'$'}type": "com.atproto.repo.strongRef",
                "cid": "bafyreiekojmzfmqtxsszcqkt5dc6ujkgnkptxchbbg776osq5tuidgopim",
                "uri": "at://did:plc:btxrwcaeyodrap5mnjw2fvmz/site.standard.document/3mwehnrqsf22g"
              },
              {
                "${'$'}type": "com.atproto.repo.strongRef",
                "cid": "bafyreienforblsiwcwbjsihxx75pkjtscqgihjfvvgv5i5qsiwtggql6zm",
                "uri": "at://did:plc:btxrwcaeyodrap5mnjw2fvmz/site.standard.publication/3lppk75kw7k26"
              }
            ]
          }
        }
        """.trimIndent()

        val view = assertIs<EmbedExternalView>(fromJson<EmbedViewUnion>(jsonString))
        val external = assertNotNull(view.external)

        assertEquals("https://lab.leaflet.pub/3mwehnrqsf22g", external.uri)
        assertEquals("Back to School — Leaflet for Learning", external.title)
        assertEquals("2026-09-25T19:05:46.382Z", external.createdAt)
        assertEquals("2026-09-26T08:30:00.000Z", external.updatedAt)
        assertEquals(4, external.readingTime)
        assertEquals("news", external.labels?.firstOrNull()?.`val`)

        val source = assertNotNull(external.source)
        assertEquals("https://lab.leaflet.pub", source.uri)
        assertEquals("Leaflet Lab Notes", source.title)
        assertEquals("Behind the scenes as we build Leaflet", source.description)
        assertTrue(source.icon!!.startsWith("https://cdn.bsky.app/img/avatar/"))

        val theme = assertNotNull(source.theme)
        assertEquals(255, theme.backgroundRGB?.r)
        assertEquals(255, theme.backgroundRGB?.g)
        assertEquals(255, theme.backgroundRGB?.b)
        assertEquals(0, theme.foregroundRGB?.r)
        assertEquals(116, theme.accentRGB?.r)
        assertEquals(145, theme.accentRGB?.g)
        assertEquals(0, theme.accentRGB?.b)
        assertEquals(255, theme.accentForegroundRGB?.r)

        val profiles = assertNotNull(external.associatedProfiles)
        assertEquals(1, profiles.size)
        assertEquals("leaflet.pub", profiles[0].handle)
        assertEquals("Leaflet", profiles[0].displayName)

        val refs = assertNotNull(external.associatedRefs)
        assertEquals(2, refs.size)
        assertEquals("at://did:plc:btxrwcaeyodrap5mnjw2fvmz/site.standard.document/3mwehnrqsf22g", refs[0].uri)
        assertEquals("bafyreiekojmzfmqtxsszcqkt5dc6ujkgnkptxchbbg776osq5tuidgopim", refs[0].cid)
        assertEquals("at://did:plc:btxrwcaeyodrap5mnjw2fvmz/site.standard.publication/3lppk75kw7k26", refs[1].uri)

        // Round trip: the hydrated view survives re-encoding.
        assertEquals(view, fromJson<EmbedExternalView>(toJson(view)))
    }

    @Test
    fun testPlainExternalViewParsing() {
        // Ordinary link cards (without standard.site records) must still parse, with the new fields null.
        val jsonString = """
        {
          "${'$'}type": "app.bsky.embed.external#view",
          "external": {
            "uri": "https://example.com/",
            "title": "Example",
            "description": "desc",
            "thumb": "https://cdn.bsky.app/img/feed_thumbnail/plain/example.jpg"
          }
        }
        """.trimIndent()

        val view = assertIs<EmbedExternalView>(fromJson<EmbedViewUnion>(jsonString))
        val external = assertNotNull(view.external)

        assertEquals("https://example.com/", external.uri)
        assertNull(external.createdAt)
        assertNull(external.readingTime)
        assertNull(external.labels)
        assertNull(external.source)
        assertNull(external.associatedRefs)
        assertNull(external.associatedProfiles)
    }

    @Test
    fun testExternalSerializeWithoutAssociatedRefs() {
        // Post side: associatedRefs must not be emitted when it is not set.
        val embed = EmbedExternal().also {
            it.external = EmbedExternalExternal(
                uri = "https://example.com/",
                title = "Example",
                description = "desc",
            )
        }

        val json = toJson(embed)
        assertFalse(json.contains("associatedRefs"), json)
    }

    @Test
    fun testExternalSerializeWithAssociatedRefs() {
        // Post side: associatedRefs is emitted as an array of strongRefs and round-trips.
        val embed = EmbedExternal().also {
            it.external = EmbedExternalExternal(
                uri = "https://lab.leaflet.pub/3mwehnrqsf22g",
                title = "Back to School",
                description = "desc",
                associatedRefs = listOf(
                    RepoStrongRef(
                        uri = "at://did:plc:btxrwcaeyodrap5mnjw2fvmz/site.standard.document/3mwehnrqsf22g",
                        cid = "bafyreiekojmzfmqtxsszcqkt5dc6ujkgnkptxchbbg776osq5tuidgopim",
                    ),
                ),
            )
        }

        val json = toJson(embed)
        assertTrue(json.contains("\"associatedRefs\""), json)
        assertTrue(json.contains("\"com.atproto.repo.strongRef\""), json)

        val parsed = assertIs<EmbedExternal>(fromJson<EmbedUnion>(json))
        val refs = assertNotNull(parsed.external?.associatedRefs)
        assertEquals(1, refs.size)
        assertEquals("bafyreiekojmzfmqtxsszcqkt5dc6ujkgnkptxchbbg776osq5tuidgopim", refs[0].cid)
    }
}
