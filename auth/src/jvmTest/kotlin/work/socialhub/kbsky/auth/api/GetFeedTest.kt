package work.socialhub.kbsky.auth.api

import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedRequest
import work.socialhub.kbsky.auth.AbstractTest
import work.socialhub.kbsky.auth.Printer.dump
import work.socialhub.kbsky.domain.Service.OYSTER_US_EAST
import kotlin.test.Test

class GetFeedTest : AbstractTest() {

    @Test
    fun testGetFeed() {
        val uri = "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.feed.generator/with-friends"

        val feeds = BlueskyFactory
            .instance(OYSTER_US_EAST.uri)
            .feed()
            .getFeed(
                FeedGetFeedRequest(auth()).also {
                    it.feed = uri
                }
            )

        feeds.data.feed.forEach {
            dump(it.post)
        }

        saveOAuthContext()
    }
}