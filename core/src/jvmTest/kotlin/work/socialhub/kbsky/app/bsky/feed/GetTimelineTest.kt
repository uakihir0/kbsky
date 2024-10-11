package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetTimelineRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetTimelineTest : AbstractTest() {

    @Test
    fun testGetTimeline() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getTimeline(
                FeedGetTimelineRequest(auth()).also {
                    it.limit = 100
                }
            )

        response.data.feed.forEach {
            dump(it.post)
        }

        val response2 = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
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
