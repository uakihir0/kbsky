package work.socialhub.kbsky.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetTimelineRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetTimelineTest : AbstractTest() {

    @Test
    fun testGetTimeline() {
        val response = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getTimeline(
                FeedGetTimelineRequest(accessJwt).also {
                    it.limit = 100
                }
            )

        checkNotNull(response.data.feed).forEach {
            print(it.post)
        }

        val response2 = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getTimeline(
                FeedGetTimelineRequest(accessJwt).also {
                    it.cursor = response.data.cursor
                    it.limit = 10
                }
            )

        checkNotNull(response2.data.feed).forEach {
            print(it.post)
        }
    }
}
