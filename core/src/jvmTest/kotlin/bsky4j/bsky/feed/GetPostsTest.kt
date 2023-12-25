package kbsky.bsky.feed

import kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.bsky.feed.FeedGetPostsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class GetPostsTest : AbstractTest() {

    @Test
    fun testGetPosts() {
        val uris = listOf(
            "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jt5ao4gpxc2u",
            "at://did:plc:bwdof2anluuf5wmfy2upgulw/app.bsky.feed.post/3jvetipo2rd2r"
        )

        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .getPosts(
                FeedGetPostsRequest(accessJwt).also {
                    it.uris = uris
                }
            )

        checkNotNull(feeds.data.posts).forEach {
            print(it)
        }
    }
}
