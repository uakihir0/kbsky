package work.socialhub.kbsky.com.atproto.repo

import kotlinx.coroutines.test.runTest

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyTypes.FeedPost
import work.socialhub.kbsky.api.entity.com.atproto.repo.RepoGetRecordRequest
import kotlin.test.Test

class GetRecordTest() : AbstractTest() {

    @Test
    fun testGetRecord() = runTest {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jqcyfp3zt22s"

        val response = client()
            .repo()
            .getRecord(
                RepoGetRecordRequest(
                    collection = FeedPost,
                    repo = "uakihir0.com",
                    uri = uri
                )
            )

        print(checkNotNull(response.data.value))
    }
}
