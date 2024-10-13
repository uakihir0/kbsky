package work.socialhub.kbsky.app.bsky.feed

import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.BlueskyFactory
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedSearchPostsRequest
import work.socialhub.kbsky.domain.Service.BSKY_SOCIAL
import kotlin.test.Test

class SearchPostsTest : AbstractTest() {

    @Test
    fun testSearchPosts() {
        val feeds = BlueskyFactory
            .instance(BSKY_SOCIAL.uri)
            .feed()
            .searchPosts(
                FeedSearchPostsRequest(
                    auth = auth(),
                    q = "SocialHub"
                )
            )

        feeds.data.posts
            .forEach { print(it) }
    }
}