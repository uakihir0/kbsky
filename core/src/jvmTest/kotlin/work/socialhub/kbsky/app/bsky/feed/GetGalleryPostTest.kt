package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeletePostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetPostsRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobRequest
import work.socialhub.kbsky.model.app.bsky.embed.EmbedDefsAspectRatio
import work.socialhub.kbsky.model.app.bsky.embed.EmbedGallery
import work.socialhub.kbsky.model.app.bsky.embed.EmbedGalleryImage
import work.socialhub.kbsky.model.app.bsky.embed.EmbedGalleryView
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GetGalleryPostTest : AbstractTest() {

    @Test
    fun testGetGalleryPost() = runTest {
        val uris = listOf(
            "at://did:plc:viznnc3sk6jhhvdkabgcboox/app.bsky.feed.post/3mnsrs5erl22y"
        )

        val response = client()
            .feed()
            .getPosts(
                FeedGetPostsRequest(auth()).also {
                    it.uris = uris
                }
            )

        val post = response.data.posts.first()
        val embed = post.embed
        assertNotNull(embed)
        assert(embed is EmbedGalleryView) {
            "Expected EmbedGalleryView but got ${embed::class.simpleName}"
        }

        val gallery = embed as EmbedGalleryView
        val items = gallery.items
        assertNotNull(items)
        assertEquals(10, items.size)

        items.forEach { item ->
            assertNotNull(item.fullsize)
        }
    }

    @Test
    fun testPostWithGallery() = runTest {
        val stream = javaClass.getResourceAsStream("/image/200x100.png")
        checkNotNull(stream)
        val bytes = stream.readBytes()

        val uploadedBlobs = (1..5).map {
            client()
                .repo()
                .uploadBlob(
                    RepoUploadBlobRequest(
                        auth = auth(),
                        name = "image_$it.png",
                        bytes = bytes,
                        contentType = "image/png"
                    )
                ).data.blob
        }

        val gallery = EmbedGallery(
            items = uploadedBlobs.mapIndexed { i, blob ->
                EmbedGalleryImage(
                    image = blob,
                    alt = "test image ${i + 1}",
                    aspectRatio = EmbedDefsAspectRatio(200, 100),
                )
            }
        )

        val postResponse = client()
            .feed()
            .post(
                FeedPostRequest(auth()).also {
                    it.text = "Gallery 投稿テスト (5枚)"
                    it.embed = gallery
                }
            )

        val uri = checkNotNull(postResponse.data.uri)
        val cid = checkNotNull(postResponse.data.cid)
        println("Posted: $uri")
        println("CID: $cid")

        // Cleanup
        client()
            .feed()
            .deletePost(
                FeedDeletePostRequest(auth()).also {
                    it.uri = uri
                }
            )
    }
}
