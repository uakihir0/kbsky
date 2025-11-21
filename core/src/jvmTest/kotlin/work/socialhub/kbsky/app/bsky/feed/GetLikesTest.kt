package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetLikesRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetLikesTest : AbstractTest() {

    @Test
    fun testLikes() {
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
