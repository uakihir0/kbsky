package work.socialhub.kbsky.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetFeedGeneratorsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetFeedGeneratorsTest : AbstractTest() {

    @Test
    fun testGetFeedGenerators() {
        val uris = listOf(
            "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.feed.generator/with-friends"
        )

        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getFeedGenerators(
                FeedGetFeedGeneratorsRequest(accessJwt).also {
                    it.feeds = uris
                }
            )

        feeds.data.feeds.forEach {
            println(it.displayName)
        }
    }
}
