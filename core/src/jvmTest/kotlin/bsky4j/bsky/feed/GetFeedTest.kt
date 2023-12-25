package kbsky.bsky.feed

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetFeedRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetFeedTest : AbstractTest() {

    @Test
    fun testGetFeed() {
        val uri = "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.feed.generator/with-friends"

        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getFeed(
                FeedGetFeedRequest(accessJwt).also {
                    it.feed = uri
                }
            )

        checkNotNull(feeds.data.feed).forEach {
            print(it.post)
        }
    }
}
