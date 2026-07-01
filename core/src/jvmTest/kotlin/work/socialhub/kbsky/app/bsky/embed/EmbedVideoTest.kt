package work.socialhub.kbsky.app.bsky.embed

import work.socialhub.kbsky.internal.share.InternalUtility.fromJson
import work.socialhub.kbsky.internal.share.InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.embed.EmbedDefsAspectRatio
import work.socialhub.kbsky.model.app.bsky.embed.EmbedVideo
import work.socialhub.kbsky.model.app.bsky.embed.EmbedVideoView
import work.socialhub.kbsky.model.app.bsky.embed.EmbedUnion
import work.socialhub.kbsky.model.app.bsky.embed.EmbedViewUnion
import work.socialhub.kbsky.model.share.Blob
import work.socialhub.kbsky.model.share.BlobRef
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * Serialization/deserialization tests for app.bsky.embed.video.
 * Covers the "presentation" hint (default/gif) used for GIF-style videos.
 * No network required.
 */
class EmbedVideoTest {

    @Test
    fun testVideoSerialize() {
        // Post side: serialize EmbedVideo with every field populated and confirm
        // $type and presentation are emitted.
        val video = EmbedVideo().also {
            it.video = Blob(
                ref = BlobRef(link = "bafkreitestcid"),
                mimeType = "video/mp4",
                size = 29264,
            )
            it.alt = "a looping clip"
            it.aspectRatio = EmbedDefsAspectRatio(2000, 1366)
            it.presentation = "gif"
        }

        val json = toJson(video)
        assertTrue(json.contains("\"app.bsky.embed.video\""), json)
        assertTrue(json.contains("\"presentation\""), json)
        assertTrue(json.contains("\"gif\""), json)

        // Confirm every field round-trips as an EmbedUnion.
        val parsed = fromJson<EmbedUnion>(json)
        val asVideo = assertNotNull(parsed.asVideo)
        assertEquals(EmbedVideo.TYPE, asVideo.type)
        assertEquals("a looping clip", asVideo.alt)
        assertEquals("gif", asVideo.presentation)
        assertEquals(2000, asVideo.aspectRatio?.width)
        assertEquals(1366, asVideo.aspectRatio?.height)

        val blob = assertNotNull(asVideo.video)
        assertEquals("bafkreitestcid", blob.ref?.link)
        assertEquals("video/mp4", blob.mimeType)
        assertEquals(29264, blob.size)
    }

    @Test
    fun testVideoViewDeserialize() {
        // Read side: real getPostThread response for a GIF post.
        // (https://bsky.app/profile/tmy.bsky.social/post/3mpdelk4i5s2h)
        val json = """
            {
              "${'$'}type": "app.bsky.embed.video#view",
              "cid": "bafkreic5fq22qdgrqklnhcrhd64ptbqm272vuppxjxqn3t2ddtyfaf6dr4",
              "playlist": "https://video.bsky.app/watch/did%3Aplc%3Ahow3ikalqaaqkm4wbrkkzdew/bafkreic5fq22qdgrqklnhcrhd64ptbqm272vuppxjxqn3t2ddtyfaf6dr4/playlist.m3u8",
              "thumbnail": "https://video.bsky.app/watch/did%3Aplc%3Ahow3ikalqaaqkm4wbrkkzdew/bafkreic5fq22qdgrqklnhcrhd64ptbqm272vuppxjxqn3t2ddtyfaf6dr4/thumbnail.jpg",
              "alt": "a looping clip",
              "presentation": "gif",
              "aspectRatio": { "width": 2000, "height": 1366 }
            }
        """.trimIndent()

        val view = fromJson<EmbedViewUnion>(json)
        val video = assertNotNull(view.asVideo)

        assertEquals(EmbedVideoView.TYPE, video.type)
        assertEquals("bafkreic5fq22qdgrqklnhcrhd64ptbqm272vuppxjxqn3t2ddtyfaf6dr4", video.cid)
        assertTrue(video.playlist.endsWith("playlist.m3u8"), video.playlist)
        assertTrue(video.thumbnail!!.endsWith("thumbnail.jpg"), video.thumbnail!!)
        assertEquals("a looping clip", video.alt)
        assertEquals("gif", video.presentation)
        assertEquals(2000, video.aspectRatio?.width)
        assertEquals(1366, video.aspectRatio?.height)
    }

    @Test
    fun testVideoViewDeserialize_noPresentation() {
        // A regular (non-GIF) video omits every optional field -> they stay null,
        // while the required cid/playlist are still populated.
        val json = """
            {
              "${'$'}type": "app.bsky.embed.video#view",
              "cid": "bafkreiregularvideo",
              "playlist": "https://video.bsky.app/watch/did%3Aplc%3Atest/bafkreiregularvideo/playlist.m3u8"
            }
        """.trimIndent()

        val view = fromJson<EmbedViewUnion>(json)
        val video = assertNotNull(view.asVideo)
        assertEquals("bafkreiregularvideo", video.cid)
        assertTrue(video.playlist.endsWith("playlist.m3u8"), video.playlist)
        assertEquals(null, video.thumbnail)
        assertEquals(null, video.alt)
        assertEquals(null, video.aspectRatio)
        assertEquals(null, video.presentation)
    }
}
