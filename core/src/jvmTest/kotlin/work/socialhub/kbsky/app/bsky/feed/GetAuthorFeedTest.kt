package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetAuthorFeedRequest
import kotlin.test.Test

class GetAuthorFeedTest : AbstractTest() {

    @Test
    fun testGetAuthorFeed() = runTest {
        val feeds = client()
            .feed()
            .getAuthorFeed(
                FeedGetAuthorFeedRequest(auth()).also {
                    it.actor = "uakihir0.com"
                }
            )

        feeds.data.feed.forEach {
            print(it.post)
        }
    }
}
