package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeletePostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedPostRequest
import work.socialhub.kbsky.api.entity.com.atproto.identity.IdentityResolveHandleRequest
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoUploadBlobRequest
import work.socialhub.kbsky.internal.share.InternalUtility.toJson
import work.socialhub.kbsky.model.app.bsky.embed.EmbedDefsAspectRatio
import work.socialhub.kbsky.model.app.bsky.embed.EmbedImages
import work.socialhub.kbsky.model.app.bsky.embed.EmbedImagesImage
import work.socialhub.kbsky.model.app.bsky.feed.FeedPostReplyRef
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import work.socialhub.kbsky.util.facet.FacetType
import work.socialhub.kbsky.util.facet.FacetUtil
import kotlin.test.Test

class PostTest : AbstractTest() {

    @Test
    fun testPost() = runTest {
        val response = client()
            .feed()
            .post(
                FeedPostRequest(auth()).also {
                    it.text = "テスト投稿"
                }
            )

        println(response.data.uri)
    }

    @Test
    fun testFeedPostWithImage() = runTest {
        // from https://placehold.jp/
        val stream = javaClass.getResourceAsStream("/image/200x100.png")
        checkNotNull(stream)

        // Upload Image
        val response1 = client()
            .repo()
            .uploadBlob(
                RepoUploadBlobRequest(
                    auth = auth(),
                    name = "icon.png",
                    bytes = stream.readBytes(),
                    contentType = "image/png"
                )
            )

        val link = checkNotNull(response1.data.blob.ref?.link)
        println(link)

        // Setup Image
        val imagesMain = EmbedImages()
        run {
            val images = mutableListOf<EmbedImagesImage>()
            imagesMain.images = images

            val image = EmbedImagesImage()
            image.image = response1.data.blob
            image.alt = "image test"

            val aspectRatio = EmbedDefsAspectRatio(
                200, 100
            )
            image.aspectRatio = aspectRatio

            images.add(image)
        }

        println(toJson(imagesMain))

        // Post With Image
        val response2 = client()
            .feed()
            .post(
                FeedPostRequest(auth()).also {
                    it.text = "画像投稿テスト"
                    it.embed = imagesMain
                }
            )

        println(response2.data.uri)
    }

    @Test
    fun testFeedPostReplay() = runTest {

        val root = client()
            .feed()
            .post(
                FeedPostRequest(auth()).also {
                    it.text = "リプライテスト (ルート)"
                }
            )

        val parent = run {
            val rootRef = RepoStrongRef(
                checkNotNull(root.data.uri),
                checkNotNull(root.data.cid),
            )
            val parentRef = RepoStrongRef(
                checkNotNull(root.data.uri),
                checkNotNull(root.data.cid),
            )

            val reply = FeedPostReplyRef().also {
                it.parent = parentRef
                it.root = rootRef
            }

            client()
                .feed()
                .post(
                    FeedPostRequest(auth()).also {
                        it.text = "リプライテスト (親)"
                        it.reply = reply
                    }
                )
        }

        println(parent.data.uri)

        val last = run {
            val rootRef = RepoStrongRef(
                checkNotNull(parent.data.uri),
                checkNotNull(parent.data.cid),
            )
            val parentRef = RepoStrongRef(
                checkNotNull(parent.data.uri),
                checkNotNull(parent.data.cid),
            )

            val reply = FeedPostReplyRef().also {
                it.parent = parentRef
                it.root = rootRef
            }

            client()
                .feed()
                .post(
                    FeedPostRequest(auth()).also {
                        it.text = "リプライテスト (子)"
                        it.reply = reply
                    }
                )
        }

        println(last.data.uri)
    }


    @Test
    fun testPostWithFacets() = runTest {

        val test = "@uakihir0.com Facet のテスト投稿 https://www.uakihir0.com/blog/p/202305-mario-movie/"
        val list = FacetUtil.extractFacets(test)

        val handles = list.records
            .filter { it.type === FacetType.Mention }
            .map { it.displayText }

        val handleToDidMap = mutableMapOf<String, String>()

        for (handle in handles) {
            val response = client()
                .identity()
                .resolveHandle(
                    IdentityResolveHandleRequest().also {
                        it.handle = handle.substring(1)
                    }
                )
            handleToDidMap[handle] = checkNotNull(response.data.did)
        }

        val facets = list.richTextFacets(handleToDidMap)

        client()
            .feed()
            .post(
                FeedPostRequest(auth()).also {
                    it.text = list.displayText()
                    it.facets = facets
                }
            )
    }

    @Test
    fun testDeleteFeed() = runTest {

        // Create
        val response = client()
            .feed()
            .post(
                FeedPostRequest(auth()).also {
                    it.text = "テスト（すぐ消す）"
                }
            )

        val uri = checkNotNull(response.data.uri)

        // Delete
        client()
            .feed()
            .deletePost(
                FeedDeletePostRequest(auth()).also {
                    it.uri = uri
                }
            )
    }
}
