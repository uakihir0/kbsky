package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetTimelineRequest
import kotlin.test.Test

class GetTimelineTest : AbstractTest() {

    @Test
    fun testGetTimeline() = runTest {
        val response = client()
            .feed()
            .getTimeline(
                FeedGetTimelineRequest(auth()).also {
                    it.limit = 100
                }
            )

        response.data.feed.forEach {
            dump(it.post)
        }

        val response2 = client()
            .feed()
            .getTimeline(
                FeedGetTimelineRequest(auth()).also {
                    it.cursor = response.data.cursor
                    it.limit = 10
                }
            )

        response2.data.feed.forEach {
            dump(it.post)
        }
    }
}
