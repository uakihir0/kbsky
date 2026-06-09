package work.socialhub.kbsky.app.bsky.embed

import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.embed.EmbedDefsAspectRatio
import work.socialhub.kbsky.model.app.bsky.embed.EmbedGallery
import work.socialhub.kbsky.model.app.bsky.embed.EmbedGalleryImage
import work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * Serialization/deserialization tests for app.bsky.embed.gallery
 * (5 or more images, up to 10). No network required.
 */
class EmbedGalleryTest {

    @Test
    fun testGallerySerialize() {
        // Post side: serialize EmbedGallery and confirm $type and items are emitted.
        val gallery = EmbedGallery().also {
            it.items = (0 until 3).map { i ->
                EmbedGalleryImage().also { img ->
                    img.alt = "alt$i"
                    img.aspectRatio = EmbedDefsAspectRatio(200, 100)
                }
            }
        }

        val json = toJson(gallery)
        assertTrue(json.contains("\"app.bsky.embed.gallery\""), json)
        assertTrue(json.contains("\"items\""), json)
        // items is a union type, so each element must emit a $type discriminator.
        assertTrue(json.contains("\"app.bsky.embed.gallery#image\""), json)

        // Confirm it round-trips as an EmbedUnion.
        val parsed = fromJson<EmbedUnion>(json)
        val asGallery = assertNotNull(parsed.asGallery)
        assertEquals(3, asGallery.items?.size)
        assertEquals("alt0", asGallery.items?.get(0)?.alt)
    }

    @Test
    fun testGalleryViewDeserialize() {
        // Read side: deserialize a JSON containing gallery#view into an EmbedViewUnion.
        val json = """
            {
              "${'$'}type": "app.bsky.embed.gallery#view",
              "items": [
                {
                  "thumbnail": "https://example.com/thumb0.jpg",
                  "fullsize": "https://example.com/full0.jpg",
                  "alt": "alt0",
                  "aspectRatio": { "width": 200, "height": 100 }
                },
                {
                  "thumbnail": "https://example.com/thumb1.jpg",
                  "fullsize": "https://example.com/full1.jpg",
                  "alt": "alt1",
                  "aspectRatio": { "width": 400, "height": 300 }
                }
              ]
            }
        """.trimIndent()

        val view = fromJson<EmbedViewUnion>(json)
        val gallery = assertNotNull(view.asGallery)
        assertEquals(2, gallery.items?.size)

        val first = assertNotNull(gallery.items?.get(0))
        assertEquals("https://example.com/thumb0.jpg", first.thumbnail)
        assertEquals("https://example.com/full0.jpg", first.fullsize)
        assertEquals("alt0", first.alt)
        assertEquals(200, first.aspectRatio?.width)
        assertEquals(100, first.aspectRatio?.height)
    }
}
