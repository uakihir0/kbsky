package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedDeleteRepostRequest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedRepostRequest
import work.socialhub.kbsky.model.com.atproto.repo.RepoStrongRef
import kotlin.test.Test

class RepostTest : AbstractTest() {

    @Test
    fun testRepost() = runTest {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jsmlerb7m22b"
        val cid = "bafyreied4repnphzjbz5lu5syibtnp72omdecpyde2yykpfjppgp32zopu"

        val ref = RepoStrongRef(uri, cid)
        val response = client()
            .feed()
            .repost(
                FeedRepostRequest(auth()).also {
                    it.subject = ref
                }
            )

        println(response.data.uri)
    }

    @Test
    fun testDeleteRepost() = runTest {

        // Create
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jsmlerb7m22b"
        val cid = "bafyreied4repnphzjbz5lu5syibtnp72omdecpyde2yykpfjppgp32zopu"

        val ref = RepoStrongRef(uri, cid)
        val response = client()
            .feed()
            .repost(
                FeedRepostRequest(auth()).also {
                    it.subject = ref
                }
            )

        val repostUri = checkNotNull(response.data.uri)

        // Delete
        client()
            .feed()
            .deleteRepost(
                FeedDeleteRepostRequest(auth()).also {
                    it.uri = repostUri
                }
            )
    }
}
