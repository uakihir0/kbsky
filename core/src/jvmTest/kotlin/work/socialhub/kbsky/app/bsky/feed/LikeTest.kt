package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeleteLikeRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedLikeRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import kotlin.test.Test

class LikeTest : AbstractTest() {

    @Test
    fun testLike() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jsmlerb7m22b"
        val cid = "bafyreied4repnphzjbz5lu5syibtnp72omdecpyde2yykpfjppgp32zopu"

        val ref = RepoStrongRef(uri, cid)
        val response = client()
            .feed()
            .like(
                FeedLikeRequest(auth()).also {
                    it.subject = ref
                }
            )

        println(response.data.uri)
    }

    @Test
    fun deleteLike() {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jsmlerb7m22b"
        val cid = "bafyreied4repnphzjbz5lu5syibtnp72omdecpyde2yykpfjppgp32zopu"

        val ref = RepoStrongRef(uri, cid)
        val response = client()
            .feed()
            .like(
                FeedLikeRequest(auth()).also {
                    it.subject = ref
                }
            )

        println(response.data.uri)

        client()
            .feed()
            .deleteLike(
                FeedDeleteLikeRequest(auth()).also {
                    it.uri = response.data.uri
                }
            )
    }
}
