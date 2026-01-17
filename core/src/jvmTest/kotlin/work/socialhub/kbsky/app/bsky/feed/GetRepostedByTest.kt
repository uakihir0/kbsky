package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetRepostedByRequest
import kotlin.test.Test

class GetRepostedByTest : AbstractTest() {

    @Test
    fun testGetRepostedBy() = runTest {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jr7b5svzuc2q"

        val response = client()
            .feed()
            .getRepostedBy(
                FeedGetRepostedByRequest(auth()).also {
                    it.uri = uri
                }
            )

        response.data.repostedBy.forEach {
            println("------------------------------")
            println(it.displayName)
            println(it.handle)
            println(it.avatar)
        }
    }
}
