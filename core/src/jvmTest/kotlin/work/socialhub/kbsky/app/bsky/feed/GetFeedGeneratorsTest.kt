package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetFeedGeneratorsRequest
import kotlin.test.Test

class GetFeedGeneratorsTest : AbstractTest() {

    @Test
    fun testGetFeedGenerators() = runTest {
        val uris = listOf(
            "at://did:plc:z72i7hdynmk6r22z27h6tvur/app.bsky.feed.generator/with-friends"
        )

        val feeds = client()
            .feed()
            .getFeedGenerators(
                FeedGetFeedGeneratorsRequest(auth()).also {
                    it.feeds = uris
                }
            )

        feeds.data.feeds.forEach {
            println(it.displayName)
        }
    }
}
