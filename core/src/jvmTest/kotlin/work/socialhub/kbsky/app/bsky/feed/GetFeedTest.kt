package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedRequest
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
                FeedGetFeedRequest(auth()).also {
                    it.feed = uri
                }
            )

        feeds.data.feed.forEach {
            dump(it.post)
        }
    }
}
