package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.Printer.dump
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedGetPostsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetPostsTest : AbstractTest() {

    @Test
    fun testGetPosts() {
        val uris = listOf(
            "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jt5ao4gpxc2u",
            "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jvetipo2rd2r"
        )

        val feeds = client()
            .feed()
            .getPosts(
                FeedGetPostsRequest(auth()).also {
                    it.uris = uris
                }
            )

        feeds.data.posts.forEach {
            dump(it)
        }
    }
}
