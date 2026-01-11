package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetActorLikesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetActorLikesTest : AbstractTest() {

    @Test
    fun testGetActorLikes() = runTest {
        val feeds = client()
            .feed()
            .getActorLikes(
                FeedGetActorLikesRequest(auth()).also {
                    it.actor = "uakihir0.com"
                    it.limit = 10
                }
            )

        feeds.data.feed.forEach {
            dump(it.post)
        }
    }
}