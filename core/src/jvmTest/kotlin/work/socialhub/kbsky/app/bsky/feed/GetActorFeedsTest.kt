package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorFeedsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetActorFeedsTest : AbstractTest() {

    @Test
    fun testGetActorFeeds() = runTest {
        val feeds = client()
            .feed()
            .getActorFeeds(
                FeedGetActorFeedsRequest(auth()).also {
                    it.actor = "uakihir0.com"
                    it.limit = 10
                }
            )

        feeds.data.feeds.forEach {
            print(it.displayName)
        }
    }
}
