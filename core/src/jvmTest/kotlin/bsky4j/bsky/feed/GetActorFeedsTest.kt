package kbsky.bsky.feed

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetActorFeedsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetActorFeedsTest : AbstractTest() {

    @Test
    fun testGetActorFeeds() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getActorFeeds(
                FeedGetActorFeedsRequest(accessJwt).also {
                    it.actor = "uakihir0.com"
                }
            )

        checkNotNull(feeds.data.feeds).forEach {
            println(it.displayName)
        }
    }
}
