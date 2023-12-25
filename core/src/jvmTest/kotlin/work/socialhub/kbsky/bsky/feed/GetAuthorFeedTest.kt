package work.socialhub.kbsky.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetAuthorFeedRequest
import work.socialhub.kbsky.domain.Service
import kotlin.test.Test

class GetAuthorFeedTest : AbstractTest() {

    @Test
    fun testGetAuthorFeed() {
        val feeds = BlueskyFactory
            .instance(Service.BSKY_SOCIAL.uri)
            .feed()
            .getAuthorFeed(
                FeedGetAuthorFeedRequest(accessJwt).also {
                    it.actor = "uakihir0.com"
                }
            )

        checkNotNull(feeds.data.feed).forEach {
            print(it.post)
        }
    }
}
