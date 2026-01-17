package work.socialhub.kbsky.app.bsky.feed

import kotlinx.coroutines.test.runTest
import work.socialhub.kbsky.AbstractTest
import work.socialhub.kbsky.api.entity.app.bsky.feed.FeedSearchPostsRequest
import kotlin.test.Test

class SearchPostsTest : AbstractTest() {

    @Test
    fun testSearchPosts() = runTest {
        val feeds = client()
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