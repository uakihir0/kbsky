package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedRequest
import kotlin.test.Test

class GetFeedTest : AbstractTest() {

    @Test
    fun testGetFeed() = runTest {
        val uri = "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.feed.generator/with-friends"

        val feeds = client()
            .feed()
            .getFeed(
                FeedGetFeedRequest(auth()).also {
                    it.feed = uri
                }
            )

        feeds.data.feed.forEach {
            dump(it.post)
        }
    }
}
