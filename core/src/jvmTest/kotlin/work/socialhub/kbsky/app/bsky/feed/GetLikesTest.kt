package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetLikesRequest
import kotlin.test.Test

class GetLikesTest : AbstractTest() {

    @Test
    fun testLikes() = runTest {
        val uri = "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jt5ao4gpxc2u"

        val feeds = client()
            .feed()
            .getLikes(
                FeedGetLikesRequest(auth()).also {
                    it.uri = uri
                }
            )

        feeds.data.likes.forEach {
            dump(it.actor)
        }
    }
}
